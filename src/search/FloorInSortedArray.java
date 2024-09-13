package search;

public class FloorInSortedArray {

    public static void main(String[] args) {
        long[] arr = new long[]{71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112};
        System.out.println(findFloor(arr, arr.length, 68));
    }

    static int findFloor(long arr[], int n, long x) {
        int start = 0;
        int end = n-1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                result = mid;
                break;
            } else if (arr[mid] < x) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result >= 0 ? result : -1;
    }
}
