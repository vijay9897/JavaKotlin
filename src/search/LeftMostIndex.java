package search;

public class LeftMostIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{10,20,20,20,20,20,207};
        System.out.println(leftIndex(arr.length, arr, 20));
    }

    static int leftIndex(int N, int arr[], int X) {

        int start = 0;
        int end = N-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || arr[mid - 1] < X) && arr[mid] == X) {
                return mid;
            } else if (arr[mid] < X){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
