package search;

public class PeakElement {

    public static void main(String[] args) {

    }

    public static int peakElement(int[] arr,int n) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return arr[0];
        }

        int start = 0;
        int end = n-1;
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid])) {
                return mid;
            } else if (mid > 0 && arr[mid-1] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
