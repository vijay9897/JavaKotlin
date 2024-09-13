package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 97, 9798, 78};
        quickSort(arr, 0, arr.length - 1);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
//            int point = naivePartition(arr, start, end);
//            int point = lomutoPartition(arr, start, end);
            int point = hoarePartition(arr, start, end);
            quickSort(arr, start, point-1);
            quickSort(arr, point+1, end);
        }
    }

    public static int naivePartition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int[] temp = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] < pivot) {
                temp[j++] = arr[i];
            }
        }
        int position = j;
        temp[j++] = pivot;
        for (int k = start; k <= end; k++) {
            if (arr[k] > pivot) {
                temp[j++] = arr[k];
            }
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
        return position;
    }

    public static int lomutoPartition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[end] = temp;
        return i+1;
    }

    public static int hoarePartition(int[] arr, int start, int end) {
        int i = start - 1;
        int j = end + 1;
        int pivot = arr[start];

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
}
