public class BitwiseOperation {

    public static void main(String[] args) {
//        System.out.println(getFirstSetBit(18));
//        System.out.println(swapBits(2));
//        System.out.println(maxConsecutiveOnes(5555));
        System.out.println(isSparse(1024));
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



}
