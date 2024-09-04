package array;

public class FrequencyInSorted {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 2, 6, 6, 7, 7, 7, 11};
        countFrequency(arr);
    }

    public static void countFrequency(int arr[]) {
        if (arr.length < 1) return;
        int freq = 1;
        int i = 1;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                freq++;
            } else {
                System.out.println("Frequency of " + arr[i-1] + " is: " + freq);
                freq = 1;
            }
        }
        if (freq > 0 ) {
            System.out.println("Frequency of " + arr[i-1] + " is: " + freq);
        }
    }
}
