package recursion;

public class LuckyNumber {

    public static int counter = 2;

    public static void main(String[] args) {
        System.out.println(isLucky(74));
    }

    public static boolean isLucky(int n) {
        if (counter > n) {
            return true;
        }

        if (n % counter == 0) {
            return false;
        }
        int next = n - (n / counter);
        counter++;
        return isLucky(next);
    }
}
