package array;

public class StrongestNeighbour {

    public static void main(String[] args) {
        maximumAdjacent(3, new int[]{89, 89, 60});
    }

    static void maximumAdjacent(int sizeOfArray, int arr[]){

        /*********************************
         * Your code here
         * Function should print max adjacents for all pairs
         * Use string buffer for fast output
         * ***********************************/
        StringBuffer s = new StringBuffer();
        for (int i = 1; i < sizeOfArray; i++)  {
            if (arr[i] == arr[i-1]) {
                s.append(arr[i] + " ");
            } else {
                s.append(Math.max(arr[i], arr[i-1]) + " ");
            }
        }
        String result = s.toString();
        System.out.println(result);
    }
}
