package search;

public class PeakElementInArray {

    public static void main(String[] args) {

    }

    public static int peakElement(int[] arr) {
        int size = arr.length;
        if (size <= 1) {
            return 0;
        }

        if (arr[0] >= arr[1]) {
            return arr[0];
        }
        if (arr[size-1] >= arr[size-2]) {
            return arr[size-1];
        }
        for (int i = 1; i < size-1; i++) {
            if (arr[i] >= arr[i-1] && arr[i] >= arr[i+1]) {
                return arr[i];
            }
        }
        return 0;
    }
}
