package ru.itis.semestr_asd1_205.shakirov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LightFloyd {
    static long count=0;

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("Floyd.csv");
             BufferedReader reader=new BufferedReader(new FileReader("matrix.txt"))) {
            for (int s = 100; s < 10001; s += 100) {
                //Заполнение матрицы
                double[][] a = new double[s][s];
                for (int i = 0; i < s; i++) {
                    for (int j = 0; j < s; j++) {
                        double db= reader.read();
                        if (db==32)db=Double.POSITIVE_INFINITY;
                        a[i][j]=db;
                    }
                }

                count=0;
                long t=System.nanoTime();
                compute(a);
                long time=System.nanoTime()-t;
                writer.write(s + ";" + count + ";" + time + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double[][] compute(double[][] D){
        for (int i = 0; i < D.length; i++) {
            D=newDn(D,i);
        }
        return D;
    }
    public static double[][] newDn(double[][] d, int n){
        int size=d.length;
        double[][] Dn=new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Dn[i][j]=Double.min(d[n][j]+d[i][n],d[i][j]);
                count++;
            }
        }
        return Dn;
    }
}
