package array;

import java.util.ArrayList;

public class MaximumInRange {

    public static void main(String[] args) {
        System.out.println(maxOccured(4, new int[]{1,4,3,1}, new int[]{15,8,5,4}, 15));
    }

    public static int maxOccured(int n, int l[], int r[], int maxx) {
        int[] helper = new int[maxx+2];
        for (int i = 0; i < n; i++) {
            helper[l[i]]++;
            helper[r[i]+1]--;
        }

        int result = 0;
        for (int i = 1; i < maxx+2; i++) {
            helper[i] = helper[i-1] + helper[i];
            if (helper[i] > helper[result]) {
                result = i;
            }
        }
        return result;
    }
}
