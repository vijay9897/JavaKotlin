package bit;

public class CountAllSet {

    public static void main(String[] args) {
        System.out.println(countSetBits(4));
    }

    public static int countSetBits(int n){

        int m = getLeftMostBit(n);
        return countSetBits(n, m);

    }

    public static int countSetBits(int n, int m) {
        if(n == 0) return 0;
        m = getNextLeftMostBit(n, m);

        if(n == ((int)1 << (m+1)) -1)
            return (int)(m+1) * (1 << m);

        n = n - (1 << m);
        return (n+1) + countSetBits(n) + m * (1 << (m-1));
    }

    public static int getLeftMostBit(int n) {
        int m = 0;
        while(n > 1) {
            n = n >> 1;
            m++;
        }
        return m;
    }

    public static int getNextLeftMostBit(int n, int m) {
        int temp = 1 << m;
        while(n < temp) {
            temp = temp >> 1;
            m--;
        }
        return m;
    }

}
