package ru.itis.semestr_asd1_205.vafin;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class DataGenerator {
    File file = new File("data.txt");
    public static void generate() throws IOException {
        Random rdm = new Random();
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt"), "cp1251"));
        int lim = 100;
        int[] arrayOfInts = new int[0];

        // generates 60 arrays of ints. Each array larger than previous on 100 elements
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < lim; j++) {
                // generates array of ints with a value from 1 to 10000
                arrayOfInts = rdm.ints(lim, 1, 10000).toArray();
            }
            os.write(Arrays.toString(arrayOfInts));
            if (i < 59) os.write("\n");
            lim += 100;
        }
        os.flush();
        os.close();
    }

    public File getFile() {
        return file;
    }
}