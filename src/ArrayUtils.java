public class ArrayUtils
{
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void shift(int[] arr, int begin, int end){
        for (int i = end; i >= begin; i--){
            arr[i+1] = arr[i];
        }
    }
}
