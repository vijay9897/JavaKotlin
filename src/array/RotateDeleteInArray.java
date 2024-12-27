package array;

import java.util.ArrayList;
import java.util.Arrays;

/*Given an array arr integers. Assume sz to be the initial size of the array. Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2) operation:

Right-rotate the array clockwise by 1.
Delete the (n– k + 1)th element from begin.
Now, Return the first element of the array.*/
public class RotateDeleteInArray {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        rotateDelete(arr);
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
    }

    public static int rotateDelete(ArrayList<Integer> arr) {
        int size = arr.size();
        int op = size / 2;
        int i = 1;
        while(i <= op) {
            rotate(arr);
            int remove = arr.size() - i + 1;
            arr.remove(remove-1);
            i++;
        }
        return arr.get(0);
    }

    public static void rotate(ArrayList<Integer> arr) {
        int last = arr.remove(arr.size()-1);
        arr.add(0, last);
    }

}
