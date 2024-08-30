package array;

import java.util.ArrayList;

public class TwoMaximum {

    public static void main(String[] args) {
        ArrayList<Integer> result = largestAndSecondLargest(3, new int[]{2, 1, 2});
        for (Integer n: result) {
            System.out.print(n + ", ");
        }
    }

    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        int max1 = arr[0], max2 = -1;
        for (int i = 1; i < sizeOfArray; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            }
            if (arr[i] > max2 && arr[i] < max1) {
                max2 = arr[i];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(max1);
        if (max1 == max2) {
            result.add(-1);
        } else {
            result.add(max2);
        }
        return result;
    }

}
