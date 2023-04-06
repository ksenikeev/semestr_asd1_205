package ru.itis.semestr_asd1_205.shakirov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Floyd {
    static int count=0;


    private double[][][] D;
    private int size;
    private double [][] D0;


    public Floyd(double[][] d0) {
        D0 = d0;
        size=d0.length;
        D=new double[size][][];
    }
    public double[][] newDn(double[][] d, int n){
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

    public void compute(){
        D[0]=newDn(D0,0);
        for (int i = 0; i < size-1; i++) {
            D[i+1]=newDn(D[i],i+1);
        }
    }

    public static void print(double[][] d){
        int size=d.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (d[i][j]==Double.POSITIVE_INFINITY)
                    System.out.print("∞");
                else
                    System.out.print((int) d[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void printAll(){
        System.out.println("D0");
        print(D0);
        for (int i = 0; i < size; i++) {
            System.out.println();
            System.out.println("D"+(i+1));
            print(D[i]);
        }
    }

    public void findAllPaths(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                findPath(i+1,j+1);
            }
        }
    }
    public void findPath(int i,int j){
        if (D[size-1][i-1][j-1]==Double.POSITIVE_INFINITY)
            System.out.println("Путей от "+i+" до "+j+" нет.");
        else
        System.out.println(i+ findWay(i-1,j-1) +j); //-1, т.к. счёт от нуля
    }
    private String findWay(int i,int j){
        if (D[size-1][i][j]==D0[i][j])
            return "-";
        for (int k = size-2; k >= 0; k--) {
            if (D[k][i][j]>D[size-1][i][j])
                return findWay(i,k+1)+(k+2)+findWay(k+1,j);
        }
        if (D0[i][j]>D[size-1][i][j])
            return findWay(i,0)+1+findWay(0,j);
        return "error";
    }
}
