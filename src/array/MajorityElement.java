package array;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4}));
    }

    public static int majorityElement(int[] arr) {
        int size = arr.length;
        if (size == 0) return -1;
        if (size == 1) return arr[0];

        int majIdx = 0;
        int count = 1;
        for (int i = 1; i < size; i++) {
            if (arr[majIdx] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majIdx = i;
                count = 1;
            }
        }

        int majCount = 0;
        for (int j : arr) {
            if (arr[majIdx] == j) {
                majCount++;
            }
        }

        if (majCount > size / 2) {
            return arr[majIdx];
        }

        return -1;
    }
}
