public class BubbleSort implements Sorter{
    public void sort(int[] arr){
        /*
         * While the array is unsorted
         * Suppose the array is sorted.
         * For each element of the array, starting at the second element
         *  if current element is greater than prior element, swap and mark the array as unsorted.
         */

        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i-1]){
                    ArrayUtils.swap(arr, i, i-1);
                    isSorted = false;
                }
            }
        }
    }
}
