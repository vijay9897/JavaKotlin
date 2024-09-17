package sort;

import java.util.Arrays;

public class NumberOfTriangles {

    public static void main(String[] args) {
        System.out.println(findNumberOfTriangles(new int[]{6, 4, 9, 7, 8}, 5));
    }

    static int findNumberOfTriangles(int arr[], int n) {
        if (n < 3) {
            return 0;
        }

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n-1; j++) {
                if ((arr[i] + arr[j]) > arr[j+1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
