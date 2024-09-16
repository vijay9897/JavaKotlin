package sort;

import java.util.Arrays;

public class ZeroSumTriplet {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(findTriplets(arr, arr.length));
    }

    public static boolean findTriplets(int arr[] , int n)
    {
        if (n < 3) {
            return false;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i+1;
            int r = n-1;
            while (l < r) {
                long sum = arr[i] + arr[l] + arr[r];
                if (sum == 0) {
                    return true;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return false;
    }
}
