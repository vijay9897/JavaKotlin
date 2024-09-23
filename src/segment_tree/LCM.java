package segment_tree;

public class LCM {

    public static void main(String[] args) {
        long[] arr = new long[]{2,3,4,6,8,16};
        long[] tree = new long[arr.length * 4];

        LCM lcm = new LCM();
        lcm.createSegmentTree(arr, tree);
        lcm.printTree(tree);
        System.out.println();
        System.out.println(lcm.getLCM(tree, arr, arr.length, 0, 2));
        lcm.updateValue(arr, tree, arr.length, 3, 8);
        lcm.printTree(tree);
        System.out.println();
        System.out.println(lcm.getLCM(tree, arr, arr.length, 2, 5));
    }

    public long getGCD(long a, long b) {
        if (a < b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

    public long LCM(long a, long b) {
        return (a * b) / getGCD(a, b);
    }

    public int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }

    public void printTree(long[] tree) {
        for (long i : tree) {
            System.out.print(i + ", ");
        }
    }

    public void createSegmentTree(long[] arr, long[] st) {
        createSegmentTreeUtil(arr, st, 0, arr.length-1, 0);
    }

    public long createSegmentTreeUtil(long[] arr, long[] st, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }

        int mid = getMid(ss, se);
        st[si] = LCM(createSegmentTreeUtil(arr, st, ss, mid, 2 * si + 1), createSegmentTreeUtil(arr, st, mid+1, se, 2 * si + 2));
        return st[si];
    }

    public long getLCM(long[] st, long[] arr, int n, int qs, int qe) {
        if (qs < 0 || qe > n-1) {
            return 0;
        }
        return getLCMUtil(st, arr, 0, n-1, 0, qs, qe);
    }

    public long getLCMUtil(long[] st, long[] arr, int ss, int se, int si, int qs, int qe) {
        if (ss > qe || se < qs) {
            return 1;
        }

        if (qs <= ss && qe >= se) {
            return st[si];
        }

        int mid = getMid(ss, se);

        return LCM(getLCMUtil(st, arr, ss, mid, 2 * si + 1, qs, qe), getLCMUtil(st, arr, mid+1, se, 2 * si + 2, qs, qe));
    }

    public void updateValue(long[] arr,long[] st,int n,int index,long new_val) {
        if (index < 0 || index > n-1) {
            return;
        }

        updateValueUtil(arr, st, 0, n-1, 0, index, new_val);
    }

    public void updateValueUtil(long[] arr,long[] st, int ss, int se, int si, int index, long new_val) {
        if (index < ss || index > se) {
            return;
        }

        if (ss == se) {
            st[si] = new_val;
            return;
        }

        int mid = getMid(ss, se);
        updateValueUtil(arr, st, ss, mid, 2 * si + 1, index, new_val);
        updateValueUtil(arr, st, mid+1, se, 2 * si + 2, index, new_val);
        st[si] = LCM(st[2 * si + 1], st[2 * si + 2]);
    }
}
