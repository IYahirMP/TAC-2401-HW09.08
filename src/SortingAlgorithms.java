import java.util.Random;

public class SortingAlgorithms {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr) {
        //Begins selection sort algorithm
        /*
         * For each position in the array:
         *   Traverse the array beginning at the current position while detecting minimal number's and position.
         *   Swap current position's value with minimal number's position's value.
         *   Go to next position.
         * */

        int min;
        for(int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }

            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[20];

        //Generating and printing random array of integers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        selectionSort(arr);

        for (int j : arr)
            System.out.print(j + " ");
    }
}
