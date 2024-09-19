package segment_tree;

public class SegmentTree {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9, 11};
        int[] tree = new int[arr.length * 4];
        new SegmentTree().createSegmentTree(arr, tree, 0, arr.length-1, 0);
        for (int i: tree)
            System.out.print(i + ", ");
    }

    public void createSegmentTree(int[] arr, int[] tree, int ss, int se, int si) {
        if (ss == se) {
            return arr[si];
        }
    }
}
