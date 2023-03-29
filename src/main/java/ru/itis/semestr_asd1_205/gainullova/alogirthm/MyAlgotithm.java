package ru.itis.semestr_asd1_205.gainullova.alogirthm;

import java.io.*;
import java.util.Arrays;

public class MyAlgotithm {

    private static int count = 0;

    public static void main(String args[]) throws FileNotFoundException {

        int[] a;

        try (FileWriter writer = new FileWriter("merge1.csv")) {

            for (int i = 100; i < 10000; i += 100) {
                a = new int[i];
                for (int j = 0; j < i; ++j) {
                    a[j] = (int) (Math.random() * i);
                }

                long t = System.nanoTime();
                count = 0;

                //сортировка массива методом слияния
                mergeSort(a);

                //записываем размер входных данных, и время выполнения
                writer.write(i + ";" + count + ";" + (System.nanoTime() - t) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //алгоритм сортировки слиянием
    public static int[] mergeSort(int[] sortArr) {
        count++;
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }
    //внутренняя рекурсивная функция для сортировки слиянием
    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        //базовый случай: если в массиве только один элемент вернуть его
        if (startIndex >= endIndex - 1) {
            count++;
            return buffer1;
        }


        //делим массив на две половины
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle); //левая часть массива
        count++;
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);  //правая часть массива
        count++;

        //слияние, объединяем две отсортированные половины
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1; //
        while (index1 < middle && index2 < endIndex) {
            count++;
            if (sorted1[index1] < sorted2[index2]) {
                count++;
                result[destIndex++] =sorted1[index1++];


            } else {
                count++;
                result[destIndex++] = sorted2[index2++];
            }

        }
        while (index1 < middle) {
            count++;
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            count++;
            result[destIndex++] = sorted2[index2++];
        }//с двух сторон (с левого и правого массива) запоняем конечный массив, выбирая наименьший элемент
        return result;
    }

}
