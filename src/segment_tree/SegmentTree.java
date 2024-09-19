package segment_tree;

public class SegmentTree {

    int[] arr = new int[]{7, 3, 9, 4, 2, 7, 3, 4, 2, 5, 3, 2, 4, 10, 4};
    int[] tree = new int[arr.length * 3];

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree();
        st.createSegmentTree();
        st.printTree();
        System.out.println(st.getSum(6, 12));
        st.update(7, 2);
        st.printTree();
        st.update(9, 10);
        st.printTree();
        System.out.println(st.getSum(8, 11));
        st.update(8, 1);
        st.printTree();
        st.update(13, 6);
        st.printTree();
        System.out.println(st.getSum(7, 8));
        System.out.println(st.getSum(9, 9));
        st.update(9, 6);
        st.printTree();
        System.out.println(st.getSum(1, 14));
        System.out.println(st.getSum(0, 10));
        System.out.println(st.getSum(7, 11));
    }

    public void printTree() {
        for (int i : tree) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public void createSegmentTree() {
        createSegmentTreeUtil(0, arr.length-1, 0);
    }

    public int createSegmentTreeUtil(int ss, int se, int si) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }
        int mid = ss +  (se - ss) / 2;
        tree[si] = createSegmentTreeUtil(ss, mid, 2*si + 1) + createSegmentTreeUtil(mid+1, se, 2*si + 2);
        return tree[si];
    }

    public int getSum(int qs, int qe) {
        if (qs < 0 || qe > arr.length - 1 || qs > qe) {
            return -1;
        }
        return getSumUtil(0, arr.length - 1, qs, qe, 0);
    }

    public int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return tree[si];
        }

        if (se < qs || ss > qe) {
            return 0;
        }

        int mid = ss +  (se - ss) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    public void update(int index, int value) {
        if(index < 0 || index > arr.length-1) {
            return;
        }

        int diff = value - arr[index];
        arr[index] = value;

        updateUtil(0, arr.length - 1, index, diff, 0);
    }

    public void updateUtil(int ss, int se, int index, int diff, int si) {
        if (index < ss || index > se) {
            return;
        }

        tree[si] += diff;
        if (se != ss) {
            int mid = ss + (se-ss) / 2;
            updateUtil(ss, mid, index, diff, 2 * si + 1);
            updateUtil(mid + 1, se, index, diff, 2 * si + 2);
        }
    }
}
