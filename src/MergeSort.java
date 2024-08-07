public class MergeSort implements Sorter{
    @Override
    public void sort(int[] arr) {
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

        sort(left);
        sort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right){
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
}
