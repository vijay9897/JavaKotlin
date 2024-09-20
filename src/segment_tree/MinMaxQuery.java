package segment_tree;

class PII extends Pair<Integer, Integer> {
    public PII() {}

    public PII(int first, int second) {
        super(first, second);
    }
}

public class MinMaxQuery {

    int[] arr = new int[]{11, 3, 7, 5, 9, 1};
    PII[] tree = new PII[4 * arr.length];

    public static void main(String[] args) {
        MinMaxQuery mm = new MinMaxQuery();
        mm.createSegmentTree();
        PII result = mm.getMinMax(0, 2);
        System.out.println(result.getFirst() + " " + result.getSecond());
        System.out.println();
        mm.updateMinMax(3, 17);
//        for (PII i : mm.tree) {
//            if (i != null) {
//                System.out.println(i.getSecond() + ", " + i.getFirst());
//            }
//        }
        PII result2 = mm.getMinMax(0, 5);
        System.out.println(result2.getFirst() + " " + result2.getSecond());
    }

    public int getMid(int ss, int se) {
        return ss + (se-ss) / 2;
    }

    public void createSegmentTree() {
        createSegmentTreeUtil(0, arr.length-1, 0);
    }

    public void createSegmentTreeUtil(int ss, int se, int si) {
        if (ss == se) {
            tree[si] = new PII(arr[ss], arr[ss]);
            return;
        }

        int mid = getMid(ss, se);
        createSegmentTreeUtil(ss, mid, 2 * si + 1);
        createSegmentTreeUtil(mid+1, se, 2 * si + 2);

        PII leftChild = tree[2 * si + 1];
        PII rightChild = tree[2 * si + 2];
        tree[si] = new PII(Math.min(leftChild.getFirst(), rightChild.getFirst()), Math.max(leftChild.getSecond(), rightChild.getSecond()));
    }

    public PII getMinMax(int qs, int qe) {
        if (qs < 0 || qe > arr.length-1) {
            return new PII(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        return getMinMaxUtil(0, arr.length-1, qs, qe, 0);

    }

    public PII getMinMaxUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return tree[si];
        }

        if (ss > qe || se < qs) {
            return new PII(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        int mid = getMid(ss, se);
        PII leftChild = getMinMaxUtil(ss, mid, qs, qe, 2 * si + 1);
        PII rightChild = getMinMaxUtil(mid+1, se, qs, qe, 2 * si + 2);

        int min = Math.min(leftChild.getFirst(), rightChild.getFirst());
        int max = Math.max(leftChild.getSecond(), rightChild.getSecond());
        return new PII(min, max);
    }

    public void updateMinMax(int index, int value) {
        if (index < 0 || index > arr.length - 1) {
            return;
        }

        arr[index] = value;
        updateMinMaxUtil(0, arr.length - 1, 0, index, value);
    }

    public void updateMinMaxUtil(int ss, int se, int si, int index, int newValue) {
        if (index < ss || index > se) {
            return;
        }

        if (ss != se) {
            int mid = getMid(ss, se);
            updateMinMaxUtil(ss, mid, 2 * si + 1, index, newValue);
            updateMinMaxUtil(mid + 1, se, 2 * si + 2, index, newValue);
            PII leftChild = tree[2 * si + 1];
            PII rightChild = tree[2 * si + 2];
            tree[si] = new PII(Math.min(leftChild.getFirst(), rightChild.getFirst()), Math.max(leftChild.getSecond(), rightChild.getSecond()));
        } else {
            tree[si] = new PII(arr[ss], arr[ss]);
        }
    }

}
