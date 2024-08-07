public class SelectionSort implements Sorter{
    public void sort(int[] arr){
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

            ArrayUtils.swap(arr, i, min);
        }
    }
}
