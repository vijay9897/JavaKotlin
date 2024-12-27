package segment_tree;

public class CorrectBracketSubsequence {

    static class Node {
        int pairs;
        int open;
        int close;
    }

    public static void main(String[] args) {
        String sequence = "())(())(())(";
        Node[] tree = new Node[sequence.length() * 4];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        buildTree(sequence, tree, 0, sequence.length()-1, 0);
        System.out.println(getLongestSequence(tree, 3, 6, sequence.length()));
        System.out.println(getLongestSequence(tree, 0, 11, sequence.length()));
    }

    public static int getMid(int low, int high) {
        return low + (high - low) / 2;
    }

    public static void buildTree(String seq, Node[] tree, int ss, int se, int si) {
        if (ss == se) {
            tree[si].pairs = 0;
            if (seq.charAt(ss) == '(') {
                tree[si].open = 1;
            } else {
                tree[si].close = 1;
            }
            return;
        }

        int mid = getMid(ss, se);
        buildTree(seq, tree, ss, mid, 2 * si + 1);
        buildTree(seq, tree, mid+1, se, 2 * si + 2);

        tree[si] = merge(tree[2 * si + 1], tree[2 * si + 2]);
    }

    public static Node merge(Node leftChild, Node rightChild) {
        Node node = new Node();
        int minMatched = Math.min(leftChild.open, rightChild.close);
        node.pairs = leftChild.pairs + rightChild.pairs + minMatched;
        node.open = leftChild.open + rightChild.open - minMatched;
        node.close = leftChild.close + rightChild.close - minMatched;
        return node;
    }

    public static int getLongestSequence(Node[] st,int qs,int qe,int n) {
        if (qs < 0 || qe > n-1) {
            return 0;
        }
        return 2 * getLongestSequenceUtil(st, 0, n-1, 0, qs, qe).pairs;
    }

    public static Node getLongestSequenceUtil(Node[] st, int ss, int se, int si, int qs, int qe) {
        if (ss > qe || se < qs) {
            return new Node();
        }
        if (qs <= ss && se <= qe) {
            return st[si];
        }
        int mid = getMid(ss, se);
        Node left = getLongestSequenceUtil(st, ss, mid, 2 * si + 1, qs, qe);
        Node right = getLongestSequenceUtil(st, mid+1, se, 2 * si + 2, qs, qe);
        return merge(left, right);
    }

}
