package sort;

public class CycleSorting {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 8, 3, 4};
        cycleSort(arr);
        for (int i: arr) {
            System.out.print(i + ", ");
        }
    }

    public static void cycleSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size-1; i++) {
            int item = arr[i];
            int pos = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < item) {
                    pos++;
                }
            }

            int temp = arr[pos];
            arr[pos] = item;
            item = temp;
            while (pos != i) {
                pos = i;
                for (int j = i + 1; j < size; j++) {
                    if (arr[j] < item) {
                        pos++;
                    }
                }
                temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
        }
    }
}
