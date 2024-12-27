package lru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LRUTester {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                int key = Integer.parseInt(str[itr++]);
                if (queryType.equalsIgnoreCase("SET")) {
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                } else {
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
//        LRUCache cache = new LRUCache(2);
//        //SET 4 4 SET 3 3 SET 2 2 SET 1 1 GET 1 GET 2 GET 3 GET 4
//        cache.set(4, 4);
//        cache.set(3, 3);
//        cache.set(2, 2);
//        cache.set(1, 1);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//        cache.set(6, 7);
//        System.out.println(cache.get(4));
//        cache.set(1, 2);
//        System.out.println(cache.get(3));


    }
}
