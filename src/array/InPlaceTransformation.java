package array;

public class InPlaceTransformation {

    public static void main(String[] args) {
        long arr[] = new long[]{1L, 0L};
        arrange(arr, 2);
        for (long l: arr) {
            System.out.print(l + ", ");
        }
    }

    static void arrange(long arr[], int n) {
        for (int  i = 0; i < n; i++) {
            arr[i] = arr[i] + ((arr[(int) arr[i]] % n) * n);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }
}
