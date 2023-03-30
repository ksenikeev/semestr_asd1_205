import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Shell {
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    int sort(int arr[]) {
        int count = 0;
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2) {
            count++;
            for (int i = gap; i < n; i += 1) {

                int temp = arr[i];
                int j;

                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                arr[j] = temp;
            }
        }
        System.out.println("Кол-во итераций: " + count);
        return 0;
    }

    public static void main(String args[]) {

            try {
                for (int i = 0; i < 51; i++) {
                    String fileName = "/Users/ilmirsarafutdinov/IdeaProjects/ShellSort/file/shell" + i + ".csv";
                    File file = new File(fileName);

                    //создаем объект FileReader для объекта File
                    FileReader fr = new FileReader(file);
                    //создаем BufferedReader с существующего FileReader для построчного считывания
                    BufferedReader reader = new BufferedReader(fr);
                    // считаем сначала первую строку
                    int[] array;
                    int count = 0;
                    String line = reader.readLine();
                    while (line != null) {
                        count++;
                        line = reader.readLine();
                    }
                    array = new int[count];

                    array = readAndWriteToArray(fileName, array);

                    printArray(array);
                    Shell sh = new Shell();
                    long t = System.nanoTime();
                    sh.sort(array);
                    long d = System.nanoTime() - t;
                    printArray(array);
                    System.out.println("Время выполнения");
                    System.out.println(d);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    static private int[] readAndWriteToArray(String fileName, int[] array) {
        int[] newArray = array;
        try {
            File file = new File(fileName);

            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            int count = 0;
            String line = reader.readLine();
            while (line != null) {
                newArray[count] = Integer.parseInt(line);
                count++;
                line = reader.readLine();
            }
            array = new int[count];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newArray;
    }
}

