package array;

import java.util.ArrayList;
import java.util.List;

public class ReducingIncreasingPattern {

    public static void main(String[] args) {
        for (Integer res: pattern(16)) {
            System.out.print(res + ", ");
        }
    }

    public static List<Integer> pattern(int N){
        ArrayList<Integer> result = new ArrayList<>();
        if(N <= 0 ) {
            result.add(N);
            return result;
        }
        reducer(N, result);
        return result;
    }

    public static void reducer(int N, ArrayList<Integer> result) {
        result.add(N);
        if(N <= 0) {
            return;
        }
        reducer(N-5, result);
        result.add(N);
    }
}
