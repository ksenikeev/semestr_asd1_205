package ru.itis.semestr_asd1_205.gaifullin;

import java.util.Scanner;

public class MyAlgorithm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String pattern = scanner.nextLine();
        System.out.print(KMP(string, pattern,0));
    }

    public static int KMP(String string, String pattern, int startIndex){
        // Вычисляем перфикс функцию для паттерна
        int[] pi = prefixFunction(pattern);
        int index = -1;
        int j = 0; // j - индекс паттерна
        for(int i = startIndex; i < string.length(); ++i){
            // Если элементы не равны и j > 0, то откатываем в начало или до тех пор, пока символы не будут совпадать.
            for(;j>0 && string.charAt(i) != pattern.charAt(j);){
                j = pi[j-1];
            }
            //Если символы совпадают, то двигаем оба курсора
            if (string.charAt(i) == pattern.charAt(j)){
                ++j;
            }
            //Если j равен последнему элементу подстроки (поиск успешен)
            if(j >= pattern.length()){
                index = i - j + 1;
                return index;
            }
        }
        return index;
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
}
