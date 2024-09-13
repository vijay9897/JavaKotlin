package sort;

public class SortingTwoTypeElements {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1, 0, 1, 0, 1};
//        sortTwoTypeElementArrayPositiveNegative(arr);
//        sortTwoTypeElementArrayEvenOdd(arr);
        sortTwoTypeElementArrayBinary(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void sortTwoTypeElementArrayPositiveNegative(int[] arr) {
        int i = -1;
        int j = arr.length;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] > 0);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void sortTwoTypeElementArrayEvenOdd(int[] arr) {
        int i = -1;
        int j = arr.length;
        while (true) {
            do {
                i++;
            } while ((arr[i] & 1) != 0);
            do {
                j--;
            } while ((arr[j] & 1) == 0);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void sortTwoTypeElementArrayBinary(int[] arr) {
        int i = -1;
        int j = arr.length;
        while (true) {
            do {
                i++;
            } while ((arr[i] & 1) == 0);
            do {
                j--;
            } while ((arr[j] & 1) == 1);

            if (i >= j) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
