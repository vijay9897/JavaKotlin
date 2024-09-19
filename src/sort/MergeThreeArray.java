package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeThreeArray {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4};
        int[] B = new int[]{1, 2, 3, 4, 5};
        int[] C = new int[]{1, 2, 3, 4, 5, 6};
        ArrayList<Integer> result = merge3sorted(A, B, C);
        for (int i: result) {
            System.out.print(i + ", ");
        }
    }

    static ArrayList<Integer> merge3sorted(int[] A, int[] B, int[] C) {
        ArrayList<Integer> merged2 = merge2Sorted(A,B);
        return merge2Sorted(merged2.stream().mapToInt(i -> i).toArray(), C);
    }

    static ArrayList<Integer> merge2Sorted(int[] a1, int[] a2) {
        int i = 0, j = 0;
        int m = a1.length;
        int n = a2.length;

        ArrayList<Integer> result = new ArrayList<>();
        while (i < m && j < n) {
            if (a1[i] == a2[j]) {
                result.add(a1[i]);
                result.add(a2[j]);
                i++;
                j++;
            } else if (a1[i] < a2[j]) {
                result.add(a1[i]);
                i++;
            } else {
                result.add(a2[j]);
                j++;
            }
        }

        while (i < m) {
            result.add(a1[i]);
            i++;
        }
        while (j < n) {
            result.add(a2[j]);
            j++;
        }
        return result;
    }
}
