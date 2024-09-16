package sort;

import java.util.Arrays;

public class TripletSum {

    public static void main(String[] args) {
        int[] arr = new int[]{40,20,10,3,6,7};
        System.out.println(find3Numbers(arr, arr.length, 24));
    }

    public static boolean find3Numbers(int arr[], int n, int x) {
        if (n < 3) {
            return false;
        }

        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++) {
            int l = i+1;
            int r = n-1;

            while (l < r) {
                int currSum = arr[i] + arr[l] + arr[r];
                if (currSum == x) {
                    return true;
                } else if (currSum < x){
                    l++;
                } else {
                    r--;
                }
            }
        }
        return  false;
    }
}
