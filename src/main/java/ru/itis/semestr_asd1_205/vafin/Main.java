package ru.itis.semestr_asd1_205.vafin;

import java.io.IOException;
import java.util.Scanner;

	public class Main {
		public static void main(String[] args) throws IOException {
			Smoothsort sms = new Smoothsort();
			DataGenerator generator = new DataGenerator();

			// generates 60 pseudorandom arrays of ints
			DataGenerator.generate();

			// reading file with pseudorandom files
			Scanner in = new Scanner(generator.getFile());
			String line;

			// while file is not empty, converting it from string[] to int[]
			while (in.hasNextLine()) {
				line = in.nextLine();
				line = line.replaceAll("\\[", "");
				line = line.replaceAll("]", "");
				line = line.replaceAll(" ", "");
				String[] numbersString = line.split(",");
				int[] numbers = new int[numbersString.length];

				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = Integer.parseInt(numbersString[i]);
				}

				long start = System.nanoTime();
				sms.sort(numbers);
				long finish = System.nanoTime();

				System.out.println("Время в нс: " + (finish-start) + " Количество итераций: " + sms.getCount());
			}
		}
	}