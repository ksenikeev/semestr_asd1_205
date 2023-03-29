package ru.itis.semestr_asd1_205.kasimov;

import java.io.FileWriter;
import java.io.IOException;

public class QuickSort {
    private static int count = 0;
    public static void main(String[] args) {
        int[] a;

        try (FileWriter writer = new FileWriter("heap.csv")) {

            for (int i = 100; i < 10000; i += 100) {
                a = new int[i];
                for (int j = 0; j < i; ++j) {
                    a[j] = (int) (Math.random() * i);
                }
                long t = System.nanoTime();
                count = 0;
                quickSort(a, 0, a.length - 1);
                writer.write(i + ";" + count + ";" + (System.nanoTime() - t) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quickSort(int[] array, int m, int n) {
        if (array.length == 0 || m >= n) {
            count++;
            return; //если массив пустой или все элементы уже отсортированы
        }
        int mid = m + (n - m) / 2;//находим середину, чтобы слева расположить числа меньше, а справа больше нее
        int md = array[mid];

        int i = m;
        int j = n;
        while (i <= j) { //смотрим, не перешли ли мы середину
            count++;
            while (array[i] < md) { //сравниваем число слева, если меньше, то переходим к следующему
                i++;
                count++;
            }
            while (array[j] > md) { //сравниваем число справа, если больше, то переходим к следующему
                j--;
                count++;
            }
            if (i <= j) {
                int s = array[i]; //если у нас предыдущие условия не удолетворены, то значит слева у нас число больше, а справа меньше
                array[i] = array[j]; //меняем их местами
                array[j] = s;
                i++;
                j--;
                count++;
            }
        }
        //у нас получилось так, что слева числа меньше, а справа больше, теперь мы эти половинки прогоняем по тому же алгоритму
        if (m < j) {
            count++;
            quickSort(array, m, j);
        }
        if (n > i) {
            count++;
            quickSort(array, i, n);
        }
    }

}


