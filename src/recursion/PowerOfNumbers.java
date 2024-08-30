package recursion;

public class PowerOfNumbers {

    public static void main(String[] args) {
        System.out.println(power(12, 21));
    }

    static long power(int N,int R)
    {
        if (R == 1) {
            return N;
        }

        long result = (power(N, R/2)) % 1000000007;
        long result2 = 0;
        if ((R & 1) != 0) {
            result2 = ((((result % 1000000007) * (result % 1000000007)) % 1000000007) * N) % 1000000007;
        } else {
            result2 = ((result % 1000000007) * (result % 1000000007)) % 1000000007;
        }
        return result2;
    }
}
