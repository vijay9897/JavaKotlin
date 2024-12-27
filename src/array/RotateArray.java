package array;

public class RotateArray {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] arr = new int[]{-1,-100,3,99};
        rotate(arr, 2);
//        reverse(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int size = nums.length - 1;
        reverse(nums, 0, size-k);
        reverse(nums, size-k+1, size);
        reverse(nums, 0, size);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
