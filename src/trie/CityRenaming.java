package trie;

public class CityRenaming {

    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int count = 1;
        boolean isUSed;

        TrieNode() {
            isEndOfWord = false;
            isUSed = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"shimla", "safari", "jammu", "delhi", "jammu", "dehradun"};
        check(arr, arr.length);
    }

    public static void check(String arr[],int n) {

        root = new TrieNode();
        for (int i = 0; i < n; i++) {
            insert(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            printCode(arr[i]);
        }
    }

    public static void insert(String key) {
        if (root == null) {
            return;
        }

        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            } else {
                (currNode.children[index].count)++;
            }
            currNode = currNode.children[index];
        }
        currNode.isEndOfWord = true;
    }

    public static void printCode(String key) {
        if (root == null) {
            return;
        }

        TrieNode currNode = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (!currNode.children[index].isUSed && currNode.children[index].count == 1) {
                sb.append((char) (index + 'a'));
                break;
            } else {
                sb.append((char) (index + 'a'));
            }
            currNode = currNode.children[index];
        }
        System.out.println(sb.toString());
    }

}
