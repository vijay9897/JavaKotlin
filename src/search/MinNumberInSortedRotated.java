package search;

public class MinNumberInSortedRotated {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 162, 462};
        System.out.println(minNumber(arr, 0, arr.length-1));
    }

    static int minNumber(int arr[], int low, int high) {
        if (high < low) {
            return -1;
        }
        if (arr[0] < arr[arr.length - 1]) {
            return arr[0];
        }
        int mid = low + (high - low) / 2;

        if (arr[mid] < arr[0] && arr[mid] < arr[mid-1]) {
            return arr[mid];
        } else if (arr[mid] > arr[0]) {
            return minNumber(arr, mid+1, high);
        } else {
            return minNumber(arr, low, mid - 1);
        }
    }
}
