package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        System.out.println(toh(2, 1, 3, 2));
    }

    public static long toh(int n, int from, int to, int aux) {
        long count = 1;
        if (n == 0) {
            return 0;
        }

        count += toh(n-1, from, aux, to);
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
        count += toh(n-1, aux, to, from);
        return count;
    }

}
