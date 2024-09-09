package array;

public class EquilibriumPoint {

    public static void main(String[] args) {
        System.out.println(equilibriumPoint(new long[]{1, 3, 5, 2, 2}));
    }

    public static int equilibriumPoint(long[] arr) {
        int size = arr.length;
        if (size == 1) {
            return 1;
        }

        long rightSum = 0;
        for (long l : arr) {
            rightSum += l;
        }

        long leftSum = 0;
        for (int  i = 0; i < size; i++) {
            if (rightSum - leftSum - arr[i] == 0) {
                return i+1;
            }
            leftSum += arr[i];
            rightSum -= arr[i];
        }
        return -1;
    }
}
