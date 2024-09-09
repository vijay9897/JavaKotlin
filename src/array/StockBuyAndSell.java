package array;

import java.util.ArrayList;

public class StockBuyAndSell {

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,2,2,4};
        System.out.println(maximizeProfit(arr));
        ArrayList<ArrayList<Integer>> result = stockBuySell(arr);
        for (ArrayList<Integer> temp: result) {
            System.out.println("Buy:" + temp.get(0) + " Sell:" + temp.get(1));
        }
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

    public static ArrayList<ArrayList<Integer>> stockBuySell(int A[]) {
        int n = A.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int startDay = 0;
        int endDay = 0;
        for (int  i= 1; i < n; i++) {
            if (A[i-1] < A[i]) {
                endDay = i;
                if (i == n-1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(startDay);
                    temp.add(endDay);
                    result.add(temp);
                }
            } else {
                if (startDay < endDay) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(startDay);
                    temp.add(endDay);
                    result.add(temp);
                }
                startDay = i;
            }
        }
        return result;
    }
}
