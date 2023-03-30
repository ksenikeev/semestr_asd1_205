import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    public void dataWrite(long count,long timer,int length){
        try(FileWriter writer = new FileWriter("output.txt", true))
        {
            // запись всей строки
            String text = Long.toString(count) + ';' + Long.toString(timer) + ';' + Integer.toString(length);
            writer.write(text);
            writer.append('\n');



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
