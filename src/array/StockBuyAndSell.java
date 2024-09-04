package array;

public class StockBuyAndSell {

    public static void main(String[] args) {
        System.out.println(maximizeProfit(new int[]{4, 2, 2, 2, 4}));
    }

    public static int maximizeProfit(int arr[]) {
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                maxProfit += (arr[i] - arr[i-1]);
            }
        }
        return maxProfit;
    }
}
