package array;

public class LongestEvenOddSubArray {

    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{1, 2, 3, 4, 5, 7, 9}));
    }

    public static int longestSubArray(int[] arr) {
        int size = arr.length;
        if (size <= 1) {
            return size;
        }

        int len = 0;
        int currLen = 1;
        int prevOdd = arr[0] % 2;
        for (int i = 1; i < size; i++) {
            if (arr[i] % 2 != prevOdd) {
                currLen++;
            } else {
                currLen = 1;
            }
            if (currLen > len) {
                len = currLen;
            }
            prevOdd = arr[i] % 2;
        }
        return len >= 2 ? len : 0;
    }
}
