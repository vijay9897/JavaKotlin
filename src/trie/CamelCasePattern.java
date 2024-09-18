package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CamelCasePattern {

    public static void main(String[] args) {
        String[] dict = {"Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"};
        findAllWords(dict, "H");
        //Hello Hi HiGeek HiTech HiTechCity HiTechLab HiTechWorld HelloWorld
    }

    static final int ALPHABET_SIZE = 26;
    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEnd;
        List<String> word = new ArrayList<>();
    }

    static void findAllWords(String[] dict, String pattern) {
        root = new TrieNode();
        for (int i = 0; i < dict.length; i++) {
            insert(dict[i]);
        }
        if (!search(pattern)) {
            System.out.print("No match found");
        }
    }

    static void insert(String key) {
        if (root == null) {
            return;
        }
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            if (Character.isLowerCase(key.charAt(i))) {
                continue;
            }
            int index = key.charAt(i) - 'A';
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }
        currNode.isEnd = true;

        currNode.word.add(key);

    }

    static boolean search(String pattern) {
        if (root == null) {
            return false;
        }

        TrieNode currNode = root;
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'A';
            if (currNode.children[index] == null) {
                return false;
            }
            currNode = currNode.children[index];
        }

        printWords(currNode);
        return true;
    }

    static void printWords(TrieNode node) {
        if (node.isEnd) {
            Collections.sort(node.word);
            for (String w: node.word) {
                System.out.print(w + " ");
            }
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                Collections.sort(child.word);
                printWords(child);
            }
        }
    }

}
