package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByAbsoluteDifference {

    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 3, 9, 2};
        List<Integer> arr = new ArrayList<>();
        for (int i: a) {
            arr.add(i);
        }
        sortABS(7, arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    static void sortABS(int k, List<Integer> arr) {
        int size = arr.size();
        Collections.sort(arr, Comparator.comparingInt(a -> Math.abs(k - a)));
    }
}
