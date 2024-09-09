package array;

public class MaximumSubArray {

    public static void main(String[] args) {
        System.out.println(maximumSumInSubArray(new int[]{-1, -2, -3, -4}));
//        maximumSumSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
    }

    public static int maximumSumInSubArray(int[] arr) {
        int size = arr.length;
        if (size <= 0) {
            return 0;
        }
        if (size == 1) {
            return arr[0];
        }

        int currSum = arr[0];
        int maxSum = currSum;

        for (int i = 1; i < size; i++) {
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void maximumSumSubArray(int[] arr) {
        int size = arr.length;
        if (size <= 0) {
            return;
        }
        if (size == 1) {
            return;
        }

        int currSum = arr[0];
        int endIndex = 0;
        int globalSum = currSum;

        for (int i = 1; i < size; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            if (currSum > globalSum) {
                globalSum = currSum;
                endIndex = i;
            }
        }

        int startIndex = endIndex;
        while (startIndex >= 0) {
            globalSum -= arr[startIndex];

            if (globalSum == 0) {
                break;
            }
            startIndex--;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
