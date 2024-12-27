public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(checkStringPalindrome("a"));
    }

    public static boolean checkStringPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
