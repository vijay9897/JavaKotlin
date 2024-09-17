package sort;

public class StringSorting {

    public static void main(String[] args) {
        System.out.println(countSort("edsab"));
    }

    public static String countSort(String arr) {
        int size = arr.length();
        int[] countArray = new int[26];
        for (int i = 0; i < size; i++) {
            countArray[arr.charAt(i) - 97]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (countArray[i] > 0 ) {
                sb.append((char)(i+97));
                countArray[i]--;
            }
        }
        return sb.toString();
    }
}
