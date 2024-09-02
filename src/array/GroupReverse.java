package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupReverse {

    public static void main(String[] args) {
        ArrayList<Long> arr = new ArrayList(Arrays.asList(5L, 6L, 8L, 9L));
        reverseInGroups(arr, 5);
        for (long l: arr) {
            System.out.print(l + ", ");
        }
    }

    public static void reverseInGroups(ArrayList<Long> arr, int k) {
        int size = arr.size();
        for (int i = 0; i < arr.size();) {
            if (i + k < size) {
                i = reverse(arr, i, i + k-1);
            } else {
                i = reverse(arr, i, size - 1);
            }
        }
    }

    static int reverse(ArrayList<Long> arr, int start, int end) {
        int returnValue = end + 1;
        while (start < end) {
            long temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
        return returnValue;
    }
}
