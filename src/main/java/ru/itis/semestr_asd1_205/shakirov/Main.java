package ru.itis.semestr_asd1_205.shakirov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size=5;
        double[][]matrix=new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String s= sc.next();
                double d=-1;
                try {
                     d = Double.parseDouble(s);
                } catch (NumberFormatException e) {
                     d =Double.POSITIVE_INFINITY;
                }finally {
                    matrix[i][j] =d ;

                }
            }

        }
        Floyd.print(matrix);

        Floyd f=new Floyd(matrix);
        f.compute();
        //f.printAll();
        //f.findPath(2,1);
        f.findAllPaths();
    }
}/*
0 3 i 5 i
i 0 6 2 i
7 i 0 i 2
i 1 4 0 6
3 i 7 i 0

№12
0 10 i 3 i
i 0 2 1 i
i i 0 i 7
i 4 8 0 2
i i 9 i 0
        */