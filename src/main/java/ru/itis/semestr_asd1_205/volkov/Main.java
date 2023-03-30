import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
package ru.itis.semestr_asd1_205.volkov;

public class Main {

    public static void main(String[] args) throws IOException {
        HeapSort heap = new HeapSort();
        RandomNumbers num = new RandomNumbers();
        DataWriter writer = new DataWriter();
        num.randomizer("input.txt");
        Scanner sc = new Scanner(num.getFile());
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] numbersString = line.split(";");
            int[] numbers = new int[numbersString.length];
            for (int i = 0; i < numbers.length; i++ ){
                numbers[i] = Integer.parseInt(numbersString[i]);
            }
            long start = System.nanoTime();
            heap.sort(numbers);
            long finish = System.nanoTime();
            long timer = finish - start;
            System.out.println(Arrays.toString(numbers));
            writer.dataWrite(heap.getCount(),timer,numbers.length);
            //System.out.println("Прошло времени, нс: " + timer + " Количество итераций: " + heap.getCount() + " Массив длинны :" + numbers.length);
        }

    }
}
