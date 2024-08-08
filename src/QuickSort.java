public class QuickSort implements Sorter{
    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public void sort(int[] arr, int start, int end){
        if (end <= start)
            return;

        int pivot = partition(arr, start, end);
        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    public int partition(int[] arr, int low, int high){
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (arr[j] < arr[high]){
                i++;
                ArrayUtils.swap(arr, i, j);
            }
        }

        i++;
        ArrayUtils.swap(arr, i , high);
        return i;
    }
}
