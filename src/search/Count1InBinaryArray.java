package search;

public class Count1InBinaryArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0};
        System.out.println(countOnes(arr, arr.length));
    }

    public static int countOnes(int arr[], int N){
        int start = 0;
        int end = N-1;
        int endPoint = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if ((mid == N-1 || arr[mid+1] == 0) && arr[mid] == 1) {
                endPoint = mid;
                break;
            } else if (arr[mid] == 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return endPoint > -1 ? endPoint + 1 : 0;
    }
}
