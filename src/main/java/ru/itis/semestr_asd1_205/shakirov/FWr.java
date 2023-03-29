package ru.itis.semestr_asd1_205.shakirov;

import java.io.*;


public class FWr {
    public static void main(String[] args) {
        try (BufferedWriter w =new BufferedWriter(new FileWriter ("matrix.txt"))){

            for (int s = 100; s < 10001; s+=100) {
                //w.write(s+" ");
                for (int i = 0; i < s; i++) {
                    for (int j = 0; j < s; j++) {
                        if (i==j) w.write(0);
                        else
                            if (Math.random()>0.5) w.write(32);
                            else
                                w.write((byte) (Math.random()*30+1));


                    }
                }
                w.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
