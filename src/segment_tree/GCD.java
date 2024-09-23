package segment_tree;

public class GCD {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,6,8,16};
        int[] tree = new int[arr.length * 4];
        GCD gcd = new GCD();
        gcd.createSegmentTree(arr, tree);
        gcd.printTree(tree);
        System.out.println();
        System.out.println(gcd.findRangeGcd(0, 2, tree, arr.length));
        gcd.updateValue(3, 8, arr, tree, arr.length);
        gcd.printTree(tree);
        System.out.println();
        System.out.println(gcd.findRangeGcd(2, 5, tree, arr.length));
    }

    public void printTree(int[] tree) {
        for (int i : tree) {
            System.out.print(i + ", ");
        }
    }

    public int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }

    public void createSegmentTree(int[] arr, int[] tree) {
        createSegmentTreeUtil(arr, tree, 0, arr.length-1, 0);
    }

    public int createSegmentTreeUtil(int[] arr, int[] tree, int ss, int se, int si) {
        if (ss == se) {
            tree[si] = arr[ss];
            return tree[si];
        }

        int mid = getMid(ss, se);

        int left = createSegmentTreeUtil(arr, tree, ss, mid, 2 * si + 1);
        int right = createSegmentTreeUtil(arr, tree, mid+1, se, 2 * si + 2);
        tree[si] = getGCD(left, right);
        return tree[si];
    }

    public int findRangeGcd(int l, int r, int[] st,int n) {
        if (l < 0 || r > n-1 || l > r) {
            return -1;
        }

        return findRangeGCDUtil(st, 0, n-1, 0, l, r, n);
    }

    public int findRangeGCDUtil(int[] st, int ss, int se, int si, int l, int r, int n) {
        if (ss > r || se < l) {
            return 0;
        }

        if (l <= ss && r >= se) {
            return st[si];
        }

        int mid = getMid(ss, se);
        return getGCD(findRangeGCDUtil(st, ss, mid, 2 * si + 1, l, r, n), findRangeGCDUtil(st, mid + 1, se, 2 * si + 2, l, r, n));
    }

    public int getGCD(int n, int m) {
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }

        if (m == 0) {
            return n;
        }
        return getGCD(m, n % m);
    }

    public void updateValue(int index,int new_val,int[] arr,int[] st,int n) {
        if (index < 0 || index > n-1) {
            return;
        }

        arr[index] = new_val;
        updateValueUtil(st, arr, 0, n-1, 0, index, new_val);
    }

    public void updateValueUtil(int[] st, int[] arr, int ss, int se, int si, int index, int new_value) {
        if (index < ss || index > se) {
            return;
        }
        if (ss == se) {
            st[si] = new_value;
            return;
        }

        int mid = getMid(ss, se);
        updateValueUtil(st, arr, ss, mid, 2 * si + 1, index, new_value);
        updateValueUtil(st, arr, mid+1, se, 2 * si + 2, index, new_value);
        st[si] = getGCD(st[2 * si + 1], st[2 * si + 2]);
    }

}
