package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(maximizeRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int maximizeRainWater(int[] arr) {
        int maxWater = 0;
        int size = arr.length;
        int[] leftMax = new int[size];
        leftMax[0] = arr[0];
        int[] rightMax = new int[size];
        rightMax[size - 1] = arr[size - 1];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        for (int i = 1; i < size - 1; i++) {
            maxWater = maxWater + (Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return maxWater;
    }
}
