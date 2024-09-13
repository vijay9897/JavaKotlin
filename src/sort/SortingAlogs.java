package sort;

public class SortingAlogs {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 4, 2, 8};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        for (int i: arr) {
            System.out.println(i + ", ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j ++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        int size = arr.length;

        for (int i = 1; i < size; i++) {
            int j = i-1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
