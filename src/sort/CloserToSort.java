package sort;

public class CloserToSort {

    public static void main(String[] args) {
        int[] arr = new int[]{230, 433, 451, 476, 612, 631, 643, 695, 938, 794};
        System.out.println(closer(arr, arr.length, 794));
    }

    static long closer(int arr[], int n, long x) {
        int l = 0, r = n-1;
        while (l <= r) {
            int mid = l + (r-l)/2;

            if (x == arr[mid]) {
                return mid;
            }
            if (mid > l && x == arr[mid-1]) {
                return mid-1;
            }
            if (mid < r && x == arr[mid+1]) {
                return mid+1;
            }
            if (arr[mid] > x) {
                r = mid - 2;
            } else {
                l = mid + 2;
            }
        }
        return -1;
    }
}
