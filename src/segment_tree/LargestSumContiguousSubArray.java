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
//        cls.printTree();
        System.out.println(query(arr, arr.length, 5, 8));
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

    public static int query(int arr[], int n, int left, int right) {

        return queryUtil(0, n-1, left, right, 0);

    }

    public static int queryUtil(int start, int end, int left, int right, int index) {
        if (start > end || start > right || end < left) {
            return Integer.MIN_VALUE;
        }
        if (start == end) {
            return tree[index].maxSum;
        }
        if (left <= start && right >= end) {
            return tree[index].maxSum;
        }

        int mid = getMid(start, end);
        int leftMax = queryUtil(start, mid, left, right, 2 * index + 1);
        int rightMax = queryUtil(mid+1, end, left, right, 2 * index + 2);
        return Math.max(leftMax, rightMax);
    }
}
