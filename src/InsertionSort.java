public class InsertionSort implements Sorter{
    public void sort(int[] arr){
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
                ArrayUtils.shift(arr, targetIdx, i - 1);
                arr[targetIdx] = temp;
            }
        }
    }

    private static int findBiggerNumber(int[] arr, int end){
        for(int i = 0; i < end; i++){
            if (arr[i] > arr[end])
                return i;
        }

        return -1;
    }
}
