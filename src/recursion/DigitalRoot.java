package recursion;

public class DigitalRoot {

    public static void main(String[] args) {
        System.out.println(digitalRoot(99999));
    }

    public static int digitalRoot(int n) {
        if(n <= 0) {
            return 0;
        }

        int sum =  (n % 10) + digitalRoot(n /10);
        if (sum <= 9)
            return sum;
        else
            return digitalRoot(sum);
    }
}
