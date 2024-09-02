package array;

import java.util.ArrayList;

public class LeaderElement {

    public static void main(String[] args) {
        ArrayList<Integer> result = leaderElement(new int[]{7, 10, 4 ,10, 6, 5, 2});
        for (int n: result) {
            System.out.print(n + ", ");
        }
    }

    public static ArrayList<Integer> leaderElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int lastLeader = arr[arr.length - 1];
        result.add(lastLeader);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= lastLeader) {
                lastLeader = arr[i];
                result.add(lastLeader);
            }
        }
        int start = 0, end = result.size() - 1;
        while(start < end) {
            int temp = result.get(start);
            result.set(start, result.get(end));
            result.set(end, temp);
            start++;
            end--;
        }
        return result;
    }
}
