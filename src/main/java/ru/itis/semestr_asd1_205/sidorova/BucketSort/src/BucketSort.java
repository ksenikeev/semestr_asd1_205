import java.util.ArrayList;

public class BucketSort {
    public static int countOfOperations = 0;

    public static void sortBucket(ArrayList<Double> array){
        if(array.size() < 2){
            return;
        }
        if(array.size() == 2){
            if(array.get(0) > array.get(1)){
                double temp = array.get(1);
                array.set(1, array.get(0));
                array.set(0, temp);
            }
            return;
        }
        boolean sorted = true;
        for (int i = 0; i < array.size()-1; i++) {
            if(array.get(i) > array.get(i+1)){
                sorted = false;
                countOfOperations++;
                break;
            }

        }
        if(sorted){
            return;
        }
        ArrayList<ArrayList<Double>> buckets = new ArrayList<>(array.size());
        for (int i = 0; i < array.size(); i++) {
            buckets.add(new ArrayList<Double>());
            countOfOperations++;
        }

        double maxValue = array.get(0);
        double minValue = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if(maxValue < array.get(i)){
                maxValue = array.get(i);
            }
            if(minValue > array.get(i)){
                minValue = array.get(i);
            }
            countOfOperations++;
        }

        double range = maxValue - minValue;

        for (int i = 0; i < array.size(); i++) {
            int bucketIndex = (int)((array.get(i) - minValue) / range * (buckets.size() - 1));
            buckets.get(bucketIndex).add(array.get(i));
            countOfOperations++;
        }

        for (int i = 0; i < buckets.size(); i++) {
            sortBucket(buckets.get(i));
            countOfOperations++;
        }

        int indx = 0;

        for (int i = 0; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                array.set(indx, buckets.get(i).get(j));
                indx++;
                countOfOperations++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            double d = ((Math.random()*100));
            arrayList.add(d);
            //System.out.print(d + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        sortBucket(arrayList);
        boolean sorted = true;
        for (int i = 0; i < arrayList.size()-1; i++) {
            if(arrayList.get(i)>arrayList.get(i+1)){
                sorted = false;
                break;
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            //System.out.print(arrayList.get(i) + " ");
        }
        System.out.println();
        System.out.println(countOfOperations);
        System.out.println(sorted);
    }
}
