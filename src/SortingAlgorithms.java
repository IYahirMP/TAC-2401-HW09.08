import java.util.Random;

public class SortingAlgorithms {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[20];

        //Generating and printing random array of integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Sorter sorter = new QuickSort();
        sorter.sort(arr);

        for (int j : arr)
            System.out.print(j + " ");
    }

}
