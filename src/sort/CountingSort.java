package sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 1, 2, 7, 5, 2};
        countingSort(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void countingSort(int[] arr) {
        int max = arr[0];
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max+1];
        for (int i = 0; i < size; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < max+1; i++) {
            count[i] = count[i] + count[i-1];
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < size; i++) {
            arr[i] = result[i];
        }
    }
}
