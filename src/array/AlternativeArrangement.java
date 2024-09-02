package array;

public class AlternativeArrangement {

    public static void main(String[] args) {
        long arr[] = new long[]{1,2,3,4,5,6};
        rearrange(arr, arr.length);
        for (long i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void rearrange(long arr[], int n){

        long temp = arr[0];
        for (int i = 0; i < n; i++) {
            long temp1 = arr[i];
            if ((i & 1) != 0) {
                arr[i] = temp;
            } else {
                arr[i] = arr[n-1-(i/2)];
            }
            temp = temp1;
        }

    }
}
