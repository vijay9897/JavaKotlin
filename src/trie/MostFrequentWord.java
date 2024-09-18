package trie;

import java.util.HashMap;

public class MostFrequentWord {

    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
        int count = 0;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    public static void main(String[] args) {
        String[] arr = new String[]{"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba", "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        root = new TrieNode();
        System.out.println(mostFrequentWord(arr, arr.length));
    }

    public static String mostFrequentWord(String arr[],int n) {
        int maxCount = 0;
        String frequentString = "";
        HashMap<String, Integer> orderMap = new HashMap<>();
        int order = 1;
        for (int i = 0; i < n; i++) {
            int currentCount = insert(arr[i]);
            if (!orderMap.containsKey(arr[i])) {
                orderMap.put(arr[i], order++);
            }
            if (maxCount <= currentCount) {
                if (maxCount < currentCount) {
                    maxCount = currentCount;
                    frequentString = arr[i];
                } else {
                    if (orderMap.get(arr[i]) > orderMap.get(frequentString)) {
                        maxCount = currentCount;
                        frequentString = arr[i];
                    }
                }
            }
        }
        return frequentString;
    }

    public static int insert(String key) {
        if (root == null) {
            return 0;
        }
        TrieNode currNode = root;
        int index;
        for (int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isEndOfWord = true;
        currNode.count = currNode.count + 1;
        return currNode.count;
    }
}
