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
//        String[] arr = new String[]{"shimla", "safari", "jammu", "delhi", "jammu", "dehradun"};
        String[] arr = new String[]{
                "xqjjcwpdathcoxxixwrohpwlsejt",
                "frdyxpwwtspwtwqknidauzmegtovbdjydghmndpnuuaftlsrbv",
                "niposfmshchqdnnqegfhnbfrsshaarqasfdkqczshofbykbpoa",
                "umeoixvunvbkheiiaideidrqkkbsykkcsfazsujmysmoftfnek",
                "aempyjbxkfiz",
                "cqpetujyaawknkrqlgmkqesfxyeakvszdcjizueviw",
                "bfrisjqyvpuoekcmgzlaeuxyr",
                "msyaowyvmmhfyuwdolovmfzmnvkausdmaovaawkzphigka",
                "mylydwfctftyazvbmcmtbjeykoxjitgsjvjdplkzadkhcdedjm",
                "cehjdoxaygzgjfhxybztdbkncm",
                "jkdijhmuxamy",
                "dxullbpgbdyptuqpwtomwkxuaxquzmysyrtnpbvy",
                "mbjcrgesilbdtui",
                "xcibgedtvbhzdhhjaazjhqcu",
                "x",
                "ppunkvxnlnljvyuueorpgegnrphovqpzjezxjntkxmjubcwool",
                "joocimnykzeepctueezbqiviesmiwtldbcesojokskgzthburw",
                "gsyrkxhvyzlpjvgwyzzuqpolkbzicwklxtamovverzvmtbnhvb",
                "joknvcxytslwqlbkbnwjyrpxqmxrsymkeubqwsiplkmynspgiq",
                "hryakgbjzjnnoasjujhqvxjlibxzlojmkxxlsffofrxkasorby",
                "ecjbwmovtroervjuhuhlsgddpsgzebpezhiphqkcbsxwkteyvl",
                "iwemevcnjzgarbevwiihlxmyfmlqcprtsfnmcnpagoaewhohqy",
                "waetybmoezreq",
                "dtfrk",
                "zsvlcajfnfjridbhytwzhvzhwqwhtyfasvvfytnrnlnkvdminb",
                "ujomrilyludxkzerrlvjfnhecqakmiqiqsybcbvwsaydydonod",
                "nmdeglquqlsqhkyznxwbvkzhpbqkeamdptuoxcjxidfcnvlmek",
                "azxeewqryieddyqahwfafoogbhjalxdjub",
                "brjqre",
                "gkvhlrxx"
        };
        check(arr, arr.length);
    }

    public static void check(String arr[],int n) {

        root = new TrieNode();
        for (int i = 0; i < n; i++) {
            System.out.println(insert(arr[i]));
        }
//        for (int i = 0; i < n; i++) {
//            printCode(arr[i]);
//        }
    }

    public static String insert(String key) {
        if (root == null) {
            return "";
        }

        TrieNode currNode = root;
        StringBuilder sb = new StringBuilder();
        boolean isUnique = true;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (currNode.children[index] == null) {
                if (isUnique) {
                    sb.append((char) (index + 'a'));
                    isUnique = false;
                }
                currNode.children[index] = new TrieNode();
            } else {
                (currNode.children[index].count)++;
            }
            currNode = currNode.children[index];
            if (currNode.count > 1) {
                sb.append((char) (index + 'a'));
            }
        }
        String result;
        if (currNode.isEndOfWord) {
            result = key + " " + currNode.count;
        } else {
            result = sb.toString();
        }
        currNode.isEndOfWord = true;
        return result;
    }

    public static void printCode(String key) {
        if (root == null) {
            return;
        }

        TrieNode currNode = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (!currNode.children[index].isUSed) {
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
