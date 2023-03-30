import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class RandomNumbers {
    File file = new File("input.txt");

    public File getFile() {
        return file;
    }

    public void randomizer(String name) throws IOException {
        String x = "";
        int count = 100;
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        for (int j = 0; j < 1000; j++) {
            if (j > 0) {
                String n = "\n";
                fileOutputStream.write(n.getBytes());
            }
            for (int i = 0; i < (1000 + count); i++) {
                x = String.valueOf((int) (Math.random()  * (i+1)) + ";");
                fileOutputStream.write(x.getBytes());
            }
            count = count + 100;
        }
    }
}