package array;

public class AlternativeArrangement {

    public static void main(String[] args) {
        long arr[] = new long[]{1, 0};
        rearrange(arr, arr.length);
        for (long i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void rearrange(long arr[], int n){

        int maxIdx = n-1, minIdx = 0;
        long max = (arr[0] < arr[n-1]) ? arr[n-1] + 1 : arr[0] + 1;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                arr[i] = arr[i] + (arr[maxIdx] % max) * max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx] % max) * max;
                minIdx++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / max;
        }

    }
}
