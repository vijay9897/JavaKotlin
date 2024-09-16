package sort;

import java.util.Arrays;

public class MergeWithoutSpace {

    public static void main(String[] args) {
        long[] a1 = new long[]{1, 3, 5, 7};
        long[] a2 = new long[]{0, 2, 6, 8, 9};
        merge(a1, a2, a1.length, a2.length);
        for (long i: a1) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (long i: a2) {
            System.out.print(i + ", ");
        }
    }

    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int i = 0, j = 0, k = n-1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                long temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                k--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
