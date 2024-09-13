package sort;

import java.util.Arrays;

public class MeetingMaximumGuests {

    public static void main(String[] args) {
        int[] arr = new int[]{13, 28, 29, 14, 40, 17, 3};
        int[] dep = new int[]{107, 95, 111, 105, 70, 127, 74};

        System.out.println(meetMaximumGuests(arr, dep));
    }

    public static int meetMaximumGuests(int[] arrival, int[] departure) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int size = arrival.length;

        int i = 1, j = 0;
        int currentGuests = 1;
        int maximumGuests = currentGuests;
        while (i < size && j < size) {
            if (arrival[i] <= departure[j]) {
                currentGuests++;
                maximumGuests = Math.max(currentGuests, maximumGuests);
                i++;
            } else {
                currentGuests--;
                j++;
            }
        }
        return maximumGuests;
    }
}
