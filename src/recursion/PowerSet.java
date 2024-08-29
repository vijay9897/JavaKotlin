package recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PowerSet {

    public static void main(String[] args) {
        ArrayList<String> ans = powerSet("abc");
        Collections.sort(ans);

        System.out.println("Result:");
        for (String s: ans) {
            System.out.print(s + ",");
        }
        System.out.println();
    }

    static ArrayList<String> powerSet(String s) {
        ArrayList<String> result = new ArrayList<>();
        powerSetUtil(s, "",  result, 0);
        return result;
    }

    static void powerSetUtil(String s, String current, ArrayList<String> result, int index) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        powerSetUtil(s, current, result, index + 1);
        powerSetUtil(s, current + s.charAt(index), result, index + 1);
    }

}
