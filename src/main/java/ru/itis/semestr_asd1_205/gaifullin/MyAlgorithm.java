package ru.itis.semestr_asd1_205.gaifullin;

import java.util.Arrays;

public class MyAlgorithm {
    public static void main(String[] args) {
        String string = "avada kedavra";
        System.out.print(Arrays.toString(prefixFunction(string)));

    }

    public static void KMP(String string, String pattern){

    }

    public static int[] prefixFunction(String string){
        int n = string.length();
        int[] pi = new int[n];
        for(int i = 1; i < n; ++i){
            int j = pi[i-1];
            // Если элементы не равны и j > 0, то откатываем в начало или до тех пор, пока символы не будут совпадать.
            for(; j > 0 && string.charAt(j) != string.charAt(i);){
                j = pi[j-1];
            }
            // Символы совпадают, увеличиваем длину подпоследовательности
            if(string.charAt(j) == string.charAt(i)){
                ++j;
            }
            //на i-ый символ ставим значение макс префикса и суфикса на данный момент
            pi[i] = j;
        }
        return pi;
    }


    public static int max(int[] array){
        int maxim = -1;
        for (int i = 0; i < array.length; ++i){
            if (array[i] > maxim) {
                maxim = array[i];
            }
        }
        return maxim;
    }
}
