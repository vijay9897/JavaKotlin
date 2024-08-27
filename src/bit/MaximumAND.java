package bit;

public class MaximumAND {

    public static void main(String[] args) {
        int arr[] = new int[4];
        arr[0] = 4;
        arr[1] = 8;
        arr[2] = 12;
        arr[3] = 16;
        System.out.println(maxAND(arr, 4));
    }

    public static int maxAND (int arr[], int N) {

        int res = 0, count;
        for(int i = 31; i >=0; i--) {
            count = checkBit(res | (1 << i), arr, N);

            if (count >= 2) {
                res = res | (1 << i);
            }
        }
        return res;

    }

    public static int checkBit(int pattern, int arr[], int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if ((pattern & arr[i]) == pattern) {
                count++;
            }
        }
        return count;
    }


}
