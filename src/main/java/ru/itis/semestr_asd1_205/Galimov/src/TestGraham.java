import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class TestGraham {

    public static void createTest() {

        for (int i = 0; i < 100; i++) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Test/test" + (i+1) + ".txt"));
                int n = 100 + (int) ( Math.random() * 10000 );
                writer.write(Integer.toString(n));
                writer.write('\n');
                for (int j = 0; j < n; j++) {
                    int a = (int) ( Math.random() * 10000 );
                    int b = (int) ( Math.random() * 10000 );
                    writer.write(Integer.toString(a));
                    writer.write(' ');
                    writer.write(Integer.toString(b));
                    writer.write('\n');
                }
                writer.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeStatistics() {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("Output/output.txt"));
            for (int i = 1; i <= 100; i++) {
                BufferedReader reader = new BufferedReader(new FileReader("Test/test"+i+".txt"));
                int n = Integer.parseInt(reader.readLine());
                output.write(Integer.toString(n) + " ");
                Point[] mas = new Point[n];
                for (int j = 0; j < n; j++) {
                    String[] a = reader.readLine().split(" ");
                    mas[j] = new Point(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
                }
                long t1 = System.nanoTime();
                Graham graham = new Graham();
                Stack<Point> otv = graham.grahamScan(mas);
                long t2 = System.nanoTime();
                output.write(Long.toString(graham.iterations) + " ");
                output.write(Long.toString(t2 - t1) + " ");
                output.write("\n");
            }
            output.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
