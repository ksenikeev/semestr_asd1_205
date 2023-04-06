package ru.itis.semestr_asd1_205.khuzin;

import java.io.FileWriter;
import java.io.IOException;

public class RadixSort {
    static void radixSort(int[] arr) {
        //поиск максимального значения в массиве
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];}
        }

        for (int s = 1; max / s > 0; s *= 10){
            count++;
            countingSortForRadix(arr, s);}


    }
    static void countingSortForRadix(int[] arr, int s) {
        int[] countingArray = {0,0,0,0,0,0,0,0,0,0};//создаем нулевой массив для подсчета вхождений

        for (int i = 0; i < arr.length; i++){
            count++;
            countingArray[(arr[i] / s) % 10]++;}

        for (int i = 1; i < 10; i++){
            count++;
            countingArray[i] += countingArray[i - 1];}

        int[] outputArray = new int[500000];//создали массив для вывода
        for (int i = arr.length - 1; i >= 0; i--){
            count++;
            outputArray[--countingArray[(arr[i] / s) % 10]] = arr[i];}

        for (int i = 0; i < arr.length; i++){
            count++;
            arr[i] = outputArray[i];}
    }
    private static int count = 0;
    public static void main(String[] args) {
        int[] arr;

        try (FileWriter writer = new FileWriter("radix.csv")) {

            for (int i = 100; i < 500000; i += 1000) {
                arr = new int[i];
                for (int j = 0; j < i; ++j) {
                    arr[j] = (int) (Math.random() * i);
                }

                long t = System.nanoTime();
                count = 0;

                radixSort(arr);

                writer.write(i + "  " + count + "  " + (System.nanoTime() - t) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();

        }





    }

}
