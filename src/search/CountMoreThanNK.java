package search;

public class CountMoreThanNK {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 9, 9, 9, 6, 0, 9, 2, 2, 9, 1, 0, 5, 8};
        System.out.println(countOccurence(arr, arr.length, 15));
    }

    public static int countOccurence(int[] arr, int n, int k) {

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] result = new int[max+1];
        int count = 0;
        for (int  i = 0; i < n; i++) {
            int c = result[arr[i]];
            if (c <= n/k) {
                result[arr[i]] = c + 1;
                if (c+1 > n/k) {
                    count++;
                }
            }
        }
        return count;
    }
}
