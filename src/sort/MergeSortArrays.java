package sort;

public class MergeSortArrays {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 4, 5};
        int[] a2 = new int[]{2, 4, 6, 8};
        int[] mergedArray = new int[a1.length + a2.length];
        mergeSortedArray(a1, a2, mergedArray);
        for (int i : mergedArray) {
            System.out.print(i + ", ");
        }
    }

    public static void mergeSortedArray(int[] a1, int[] a2, int[] resultArray) {
        int k= 0;
        int i = 0, j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                resultArray[k++] = a1[i++];
            } else {
                resultArray[k++] = a2[j++];
            }
        }

        while (i < a1.length) {
            resultArray[k++] = a1[i++];
        }
        while (j < a2.length) {
            resultArray[k++] = a2[j++];
        }
    }
}
