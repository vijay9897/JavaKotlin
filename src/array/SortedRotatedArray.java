package array;

public class SortedRotatedArray {

    public static void main(String[] args) {
        System.out.println(checkRotatedAndSorted(new int[]{1, 2, 3, 4}, 3));
    }

    public static boolean checkRotatedAndSorted(int arr[], int num) {
        if (num == 1) {
            return true;
        }

        int count = 0;
        for (int i = 1; i < num; i++) {
            if (arr[i-1] > arr[i]) {
                if (count == 0 && arr[0] < arr[i]) {
                    return false;
                } else if (count > 0) {
                    if (arr[0] < arr[i] || arr[i-1] >  arr[i]) {
                        return false;
                    }
                }
                count++;
            }
        }
        return count >= 1;
    }
}
