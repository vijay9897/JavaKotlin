package segment_tree;

public class LargestSumContiguousSubArray {

    static class Node {
        int sum, prefixSum, suffixSum, maxSum;
    }
    static Node[] tree = new Node[32];

    public static void main(String[] args) {
        int[] arr = new int[]{-2,-3,4,-1,-2,1,5,-3};
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        LargestSumContiguousSubArray cls = new LargestSumContiguousSubArray();
        cls.build(arr, 0, arr.length-1, 0);
        System.out.println(query(arr, arr.length, 5, 8));
        update(arr, arr.length, 1, 11);
//        cls.printTree();
        System.out.println(query(arr, arr.length, 1, 3));
    }

    public void printTree() {
        for (Node i : tree) {
            if (i != null) {
                System.out.println(i.sum + ", " + i.prefixSum + ", " + i.suffixSum + ", " + i.maxSum);
            }
        }
    }

    public static int getMid(int low, int high) {
        return low + (high - low) / 2;
    }

    public void build(int[] arr, int low, int high, int index) {
        if (low == high) {
            tree[index].sum = arr[low];
            tree[index].prefixSum = arr[low];
            tree[index].suffixSum = arr[low];
            tree[index].maxSum = arr[low];
        } else {
            int mid = getMid(low, high);

            build(arr, low, mid, 2 * index + 1);
            build(arr, mid + 1, high, 2 * index + 2);
            Node left = tree[2 * index + 1];
            Node right = tree[2 * index + 2];
            tree[index].sum = left.sum + right.sum;
            tree[index].prefixSum = Math.max(left.prefixSum, left.sum + right.prefixSum);
            tree[index].suffixSum = Math.max(right.suffixSum, right.sum + left.suffixSum);
            tree[index].maxSum = Math.max(
                    tree[index].prefixSum,
                    Math.max(tree[index].suffixSum,
                            Math.max(left.maxSum,
                                    Math.max(right.maxSum,
                                            left.suffixSum + right.prefixSum
                                    )
                            )
                    )
            );
        }
    }

    public static int query(int[] arr, int n, int left, int right) {

        return queryUtil(0, n-1, left-1, right-1, 0).maxSum;

    }

    public static Node queryUtil(int index, int low, int high, int l, int r) {
        Node result = new Node();
        result.sum = result.prefixSum = result.suffixSum
                = result.maxSum = Integer.MIN_VALUE;

        if (r < low || high < l) {
            return result;
        }

        if (l <= low && high <= r) {
            return tree[index];
        }

        int mid = (low + high) / 2;

        if (l > mid) {
            return queryUtil(2 * index + 2, mid + 1, high,
                    l, r);
        }
        if (r <= mid) {
            return queryUtil(2 * index + 1, low, mid, l,
                    r);
        }

        Node left
                = queryUtil(2 * index + 1, low, mid, l, r);
        Node right = queryUtil( 2 * index + 2, mid + 1,
                high, l, r);
        result.sum = left.sum + right.sum;
        result.prefixSum = Math.max(
                left.prefixSum, left.sum + right.prefixSum);

        result.suffixSum = Math.max(
                right.suffixSum, right.sum + left.suffixSum);
        result.maxSum = Math.max(
                result.prefixSum,
                Math.max(
                        result.suffixSum,
                        Math.max(left.maxSum,
                                Math.max(right.maxSum,
                                        left.suffixSum
                                                + right.prefixSum))));

        return result;

    }

    static void update(int[] arr, int n, int index, int value) {
            if (index-1 < 0 || index-1 > n-1) {
                return;
            }
            updateUtil(0, 0, n-1, index-1, value);
    }

    public static void updateUtil(int index, int low, int high, int idx, int value) {
        if (low == high) {
            tree[index].sum = value;
            tree[index].prefixSum = value;
            tree[index].suffixSum = value;
            tree[index].maxSum = value;
        }
        else {
            int mid = (low + high) / 2;

            if (idx <= mid) {
                updateUtil(2 * index + 1, low, mid, idx,
                        value);
            } else {
                updateUtil(2 * index + 2, mid + 1, high,
                        idx, value);
            }
            tree[index].sum = tree[2 * index + 1].sum
                    + tree[2 * index + 2].sum;

            tree[index].prefixSum = Math.max(
                    tree[2 * index + 1].prefixSum,
                    tree[2 * index + 1].sum
                            + tree[2 * index + 2].prefixSum);

            tree[index].suffixSum = Math.max(
                    tree[2 * index + 2].suffixSum,
                    tree[2 * index + 2].sum
                            + tree[2 * index + 1].suffixSum);

            tree[index].maxSum = Math.max(
                    tree[index].prefixSum,
                    Math.max(
                            tree[index].suffixSum,
                            Math.max(
                                    tree[2 * index + 1].maxSum,
                                    Math.max(
                                            tree[2 * index + 2].maxSum,
                                            tree[2 * index + 1].suffixSum
                                                    + tree[2 * index + 2]
                                                    .prefixSum
                                    )
                            )
                    )
            );
        }
    }

}
