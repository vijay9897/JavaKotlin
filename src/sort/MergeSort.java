package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2, 8};
        mergeSort(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        mergeArray(arr, start, mid, end);
    }

    public static void mergeArray(int[] arr, int l, int m, int r) {
        int k= 0;
        int i = l, j = m+1;
        int[] temp = new int[r - l + 1];
        while (i <= m && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }

        int l1 = l;
        for (int n = 0; n < temp.length; n++) {
            arr[l1++] = temp[n];
        }
    }
}
