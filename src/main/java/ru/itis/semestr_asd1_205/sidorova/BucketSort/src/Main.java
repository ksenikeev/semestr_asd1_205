import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))) {
            FileWriter answersFile = new FileWriter("answers.txt");
            FileWriter countOperationsFile = new FileWriter("operations.txt");

            int arraySize = Integer.parseInt(fileReader.readLine().split(":")[1]);
            ArrayList<Double> arrayList = new ArrayList<>();
            while (fileReader.ready()){
                String line = fileReader.readLine();
                if(line.contains("Array") || line.contains("end")){
                    long temp = System.currentTimeMillis();
                    BucketSort.sortBucket(arrayList);
                    long time = System.currentTimeMillis() - temp;
                    answersFile.write("Sorted array:"+arraySize+"\n");
                    for (int i = 0; i < arrayList.size(); i++) {
                        answersFile.write(arrayList.get(i)+"\n");
                    }
                    countOperationsFile.write(arraySize+":"+BucketSort.countOfOperations+":"+time+"\n");
                    BucketSort.countOfOperations = 0;
                    String[] s = line.split(":");
                    if(s.length == 2){
                        arraySize = Integer.parseInt(s[1]);
                        arrayList = new ArrayList<>();
                    }
                }else{
                    arrayList.add(Double.parseDouble(line));
                }
            }
            answersFile.close();
            countOperationsFile.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
