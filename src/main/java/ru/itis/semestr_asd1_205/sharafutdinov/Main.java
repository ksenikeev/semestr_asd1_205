import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        try {
            new File("/Users/ilmirsarafutdinov/IdeaProjects/ShellSort/file").mkdirs();
            for (int i = 0; i < 51; i++) {
                FileWriter writer = new FileWriter("/Users/ilmirsarafutdinov/IdeaProjects/ShellSort/file/shell" + i + ".csv");

                int randomNum = rnd(100, 10000);
                System.out.println(randomNum);
                for (int j = 0; j < 10000; j++) {
                    String str = rnd(0, 1000) + "\n";
                    System.out.println(str);
                    writer.write(str);
                }
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}