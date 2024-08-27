package bit;

public class BitwiseOperation {

    public static void main(String[] args) {
//        System.out.println(getFirstSetBit(18));
//        System.out.println(swapBits(2));
//        System.out.println(maxConsecutiveOnes(5555));
//        System.out.println(isSparse(1024));
        System.out.println(powerOfTwo(555));
    }

    public static int getFirstSetBit(int n){
        if (n == 0) return 0;
        int index = 1;
        while((n&1) == 0) {
            index++;
            n = n>>1;
        }
        return index;
    }

    public static int swapBits(int n) {
        int evenBits = n & 0xAAAAAAAA;
        int oddBits = n & 0x55555555;

        evenBits = evenBits >> 1;
        oddBits = oddBits << 1;

        return evenBits | oddBits;
    }

    public static int maxConsecutiveOnes(int N) {
        int currentCount = 0, maxCount = 0;
        while (N > 0) {
            if ((N & 1) == 0) {
                if (currentCount >= maxCount) {
                    maxCount = currentCount;
                }
                currentCount = 0;
                while ((N & 1) == 0) {
                    N >>= 1;
                }
            } else {
                currentCount++;
                N >>= 1;
            }
        }
        if (currentCount > maxCount) {
            maxCount = currentCount;
        }
        return maxCount;
    }

    public static boolean isSparse(int n) {
        return (n & (n>>1)) == 0;
    }

    public static boolean powerOfTwo(int n) {
        if (n == 0) return false;
        return (n & (n-1)) == 0;
    }

    public static int posOfRightMostDiffBit(int m, int n) {

        if (m == n) return -1;
        int xor = m ^ n;
        int pos = 1;
        while ((xor & 1) == 0) {
            pos++;
            xor = xor >> 1;
        }
        return pos;

    }

    public static int countBitsFlip(int a, int b){

        int xor = a ^ b;
        int count = 0;
        while(xor > 0) {
            xor &= (xor-1);
            count++;
        }
        return count;

    }

    public static int greyConverter(int n) {

        // Your code here
        return n ^ (n >> 1);
    }

    public static int grayToBinary(int n) {

        int res = n;
        while(n > 0) {
            n >>= 1;
            res ^= n;
        }
        return res;

    }

}
