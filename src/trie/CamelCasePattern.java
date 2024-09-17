package trie;

import java.util.ArrayList;
import java.util.Collections;

public class CamelCasePattern {

    public static void main(String[] args) {
        String[] dict = {"Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab"};
        findAllWords(dict, "HT");
    }

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] smallCase = new TrieNode[ALPHABET_SIZE];
        TrieNode[] capitalCase = new TrieNode[ALPHABET_SIZE];
    }

    static void findAllWords(String[] dict, String pattern) {
        TrieNode root = new TrieNode();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < dict.length; i++) {
            if (insert(root, dict[i], pattern)) {
                result.add(dict[i]);
            }
        }
        if (result.isEmpty()) {
            System.out.print("No match found");
        } else {
            Collections.sort(result);
            for (String s: result) {
                System.out.print(s + " ");
            }
        }
    }

    static boolean insert(TrieNode root, String key, String pattern) {
        if (root == null) {
            return false;
        }

        int patternIndex = 0;
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (isCapitalCase(ch)) {
                if (patternIndex < pattern.length() && pattern.charAt(patternIndex) == ch)
                    patternIndex++;
                int index = ch - 'A';
                if (currNode.capitalCase[index] == null) {
                    currNode.capitalCase[index] = new TrieNode();
                }
                currNode = currNode.capitalCase[index];
            } else {
                int index = ch - 'a';
                if (currNode.smallCase[index] == null) {
                    currNode.smallCase[index] = new TrieNode();
                }
                currNode = currNode.smallCase[index];
            }
        }
        return patternIndex == pattern.length();
    }

    static boolean isCapitalCase(char ch) {
        return ch >= 65 && ch <= 90;
    }

}
