package array;

public class SortZeroOneTwo {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2};
        sortArray(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public static void sortArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        int k = 0;
        while (k <= j) {
            if (arr[k] == 0) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                i++;
                k++;
            } else if (arr[k] == 2) {
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j--;
            } else {
                k++;
            }
        }
    }


}
