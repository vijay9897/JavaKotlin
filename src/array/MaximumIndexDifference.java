package array;

public class MaximumIndexDifference {

    /*
    * Given an array arr of positive integers. The task is to return the maximum of j - i subjected to the constraint of arr[i] < arr[j] and i < j.
    * */

    public static void main(String[] args) {
        System.out.println(maxIndexDiff(new int[]{34, 8, 10, 3, 2, 80, 30, 33, 1}));
//        System.out.println(maxIndexDiff(new int[]{24, 7, 20, 12, 0, 4, 20, 0, 3, 3, 21, 20, 28, 25}));
    }

    public static int maxIndexDiff(int[] arr) {
        int maxDiff = 0;
        int size = arr.length;
        int j = 0;
        for (int i = 1; i < size;i ++) {
            if (arr[i] < arr[j]) {
                maxDiff = Math.max(maxDiff, i-j);
                j = i;
            }
        }
        return maxDiff;
    }

}
