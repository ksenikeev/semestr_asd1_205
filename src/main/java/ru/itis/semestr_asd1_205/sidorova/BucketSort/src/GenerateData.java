import java.io.FileWriter;
import java.io.IOException;

public class GenerateData {
    private static final int COUNT_OF_ARRAYS = 100;
    private static final int MAX_SIZE_OF_ARRAY = 10_000;
    private static final int MIN_SIZE_OF_ARRAY = 100;
    private static final int MAX_VALUE = 100_000;
    private static final int MIN_VALUE = 100;

    public static void main(String[] args) {
        try(FileWriter file = new FileWriter("data.txt")){
            for (int i = 0; i < COUNT_OF_ARRAYS; i++) {
                int array_size = (int)(Math.random() * (MAX_SIZE_OF_ARRAY - MIN_SIZE_OF_ARRAY) + MIN_SIZE_OF_ARRAY);
                file.write("Array:"+array_size+"\n");
                int rangeValue = (int)(Math.random() * (MAX_VALUE - MIN_VALUE) + MIN_VALUE);
                for (int j = 0; j < array_size; j++) {
                    file.write(Math.random()*rangeValue + "\n");
                }
            }
            file.write("end");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
