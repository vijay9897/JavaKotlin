package array;

public class MaximumSumCircularArray {

    public static void main(String[] args) {
        System.out.println(maximumCircularSum(new int[]{1, 40, -14, 7, 6, 5, -4, -1}));
    }

    public static int maximumCircularSum(int[] arr) {
        int size = arr.length;
        if (size == 0) return 0;
        if (size == 1) return arr[0];

        int normalSum = maximumSum(arr);

        if (normalSum < 0) {
            return normalSum;
        }

        int totalSum = 0;
//        int minSum = arr[0];
//        int currMin = arr[0];
//
//        for (int i = 1; i < size; i++) {
//            totalSum += arr[i];
//            currMin = Math.min(arr[i], currMin + arr[i]);
//            if (minSum > currMin) {
//                minSum = currMin;
//            }
//        }

        for (int i = 0; i < size; i++) {
            totalSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxCircular = totalSum + maximumSum(arr);

        return Math.max(normalSum, maxCircular);
    }

    public static int maximumSum(int[] arr) {
        int size = arr.length;
        if (size == 0) return 0;
        if (size == 1) return arr[0];

        int maxSum = arr[0];
        int currSum = arr[0];
        for (int i = 1; i < size; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
}
