package trie;

public class InsertAndSearch {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    public static void main(String[] args) {

        String[] list = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
        TrieNode root = new TrieNode();
        for (String s : list) {
            insert(root, s);
        }
        System.out.println(search(root, "theire"));
    }

    static void insert(TrieNode root, String key)
    {
        if (root == null) {
            return;
        }

        TrieNode currNode = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isEndOfWord = true;
    }

    //Function to use TRIE data structure and search the given string.
    static boolean search(TrieNode root, String key)
    {
        if (root == null) {
            return false;
        }

        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                return false;
            }
            currNode = currNode.children[index];
        }
        return currNode.isEndOfWord;
    }
}
