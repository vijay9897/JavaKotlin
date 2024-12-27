package search;

import java.util.ArrayList;

public class IndexesOfSubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,7,5};

        ArrayList<Integer> result = subArraySum(arr, arr.length, 12);
        for (int i: result) {
            System.out.print(i + ", ");
        }

    }

    public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        return new ArrayList();
    }

}
