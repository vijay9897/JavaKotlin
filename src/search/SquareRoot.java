package search;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(squareRoot(11));
    }

    public static int squareRoot(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 0;
        int end = x;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
