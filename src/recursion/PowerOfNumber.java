package recursion;

public class PowerOfNumber {

    public static void main(String[] args) {
        System.out.println(powerOfNumber(9, 9));
    }

    public static int powerOfNumber(int n, int p) {
        if (p == 0)
            return 1;
        if (p == 1)
            return n;

        return n * powerOfNumber(n, p-1);
    }
}
