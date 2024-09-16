package search;

public class MissingAndRepeatingNumber {

    public static void main(String[] args) {

    }

    public static void missingAndRepeating(int n, int[] arr) {
        int actualSum = (n*(n+1))/2;
        int actualProd = 1;
        for (int i = 1; i < n; i++) {
            actualProd *= i;
        }

        int sum = 0;
        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prod *= arr[i];
        }

        

    }
}
