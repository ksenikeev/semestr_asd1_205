package ru.itis.semestr_asd1_205.gaifullin;

public class MyAlgorithm {
        public static void main(String[] args) {
            System.out.println("Hello world!");
            String string = "aabaaab";
            System.out.print(prefixFunction(string));
            System.out.print("");
        }

        public static int prefixFunction(String string){
            int n = string.length();
            int[] pi = new int[n];
            for(int i = 1; i < n; ++i){
                int j = pi[i-1];
                while (j > 0 && string.charAt(i)!= string.charAt(j)){
                    j = pi[j-1];
                }
                if (string.charAt(i) == string.charAt(j)){
                    ++j;
                }
                pi[i] = j;
            }
            return max(pi);
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
