package recursion;

import java.util.ArrayList;

public class PhoneDigitCombinations {

    public static void main(String[] args) {
        ArrayList<String> result = possibleWords(new int[]{2, 3, 4}, 3);
        for (String s: result) {
            System.out.print(s + ", ");
        }
    }

    static ArrayList<String> possibleWords(int a[], int N) {
        ArrayList<String> result = new ArrayList<>();
        possibleWords(a, N, result, "", 0);
        return result;
    }

    static void possibleWords(int a[], int N, ArrayList<String> result, String current, int index) {
        if (index == N) {
            result.add(current);
            return;
        }
        char[] chars = getMapping(a[index]).toCharArray();
        for (char ch: chars) {
            possibleWords(a, N, result, current + ch, index+1);
        }
    }

    static String getMapping(int n) {
        switch (n) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

}
