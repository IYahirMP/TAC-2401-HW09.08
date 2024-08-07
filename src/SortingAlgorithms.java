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

    public static int findBiggerNumber(int[] arr, int number){
        for(int i = 0; i < number; i++){
            if (arr[i] > arr[number])
                return i;
        }

        return -1;
    }

    public static void shift(int[] arr, int begin, int end){
        for (int i = end; i >= begin; i--){
            arr[i+1] = arr[i];
        }
    }

    public static void insertionSort(int[] arr){
        /*
        * For each element starting at the second element
        *   store the element's value
        *   find a number bigger on the left side of the array then store its index
        *   if no number is bigger then continue with the next element.
        *   Else:
        *       shift the elements starting from the bigger element´s position all the way to the current element.
        *       insert the element´s value in place of the bigger element.
        * */
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int targetIdx = findBiggerNumber(arr, i);
            if (targetIdx == -1){
                continue;
            }
            if (targetIdx < i) {
                shift(arr, targetIdx, i - 1);
                arr[targetIdx] = temp;
            }
        }
    }

    public static void mergeSort(int[] arr){
        /*
         * Merge sort is a recursive algorithm.
         * 1. Stops if array length is 1.
         * 2. divides an array in halves.
         * 3. Both parts are ordered recursively.
         * 4. Ordered parts are merged.
         *
         * Merging consists of rearranging both parts into one bigger ordered array
         * 1. If left´s first number is the smallest, then it is appended to the array
         *      Else, first number in the right is appended.
         * 2. Append the remainings of both arrays.
         */

        if (arr.length <= 1)
            return;

        int size = arr.length / 2;
        int[] left = new int[size];
        int[] right = new int[arr.length - size];

        for(int i=0; i < size; i++)
            left[i] = arr[i];
        for(int i=size; i <arr.length; i++)
            right[i-size] = arr[i];

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right){
        int i, j,k;
        i = j = k = 0;

        /*
        * While there are elements in both arrays:
        *   insert the smallest element from both arrays
        *   go to next position
        *
        * When all elements of an array are used it is needed to fill the rest of the array
        * with the remaining ordered array.
        * */

        //Selective insertion
        while (j < left.length && k < right.length) {
            if (left[j] < right[k]) {
                arr[i] = left[j++];
            }else{
                arr[i] = right[k++];
            }
            i++;
        }

        //Insertion of the remainder
        while( j < left.length){
            arr[i++] = left[j++];
        }
        while( k < right.length){
            arr[i++] = right[k++];
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

        mergeSort(arr);

        for (int j : arr)
            System.out.print(j + " ");
    }
}
