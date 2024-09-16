package sort;

import java.util.Arrays;

public class PowerPairInArray {

    //The trick here is if y > x then x^y > y^x with some exceptions.
    //Sort array Y[] and for every x in X[], find the index idx of the smallest number greater than x in Y[] using

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 6};
        int[] brr = new int[]{1, 5};
        System.out.println(countPairs(arr, brr, arr.length, brr.length));
    }

    public static long countPairs(int x[], int y[], int M, int N) {
        int NoOfY[] = new int[5];
        for (int i = 0; i < N; i++)
            if (y[i] < 5)
                NoOfY[y[i]]++;
        Arrays.sort(y);
        long total_pairs = 0;

        for (int i = 0; i < M; i++)
            total_pairs += count(x[i], y, N, NoOfY);

        return total_pairs;
    }

    public static long count(int x, int[] y, int n, int[] NoOfY) {
        if (x == 0)
            return 0;

        if (x == 1)
            return NoOfY[0];

        int idx = Arrays.binarySearch(y, x);
        int ans;
        if (idx < 0) {
            idx = Math.abs(idx + 1);
            ans = y.length - idx;
        }
        else {
            while (idx < n && y[idx] == x) {
                idx++;
            }
            ans = y.length - idx;
        }

        ans += (NoOfY[0] + NoOfY[1]);

        if (x == 2)
            ans -= (NoOfY[3] + NoOfY[4]);

        if (x == 3)
            ans += NoOfY[2];

        return ans;
    }
}
