package lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity = 0;

    LRUCache(int cap) {
        this.capacity = cap;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (tail == node) {
                tail = node.prev;
            }
            removeNode(node);
            addNode(node);
            return node.data;
        }
        return -1;
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.data = value;
            removeNode(node);
            addNode(node);
        } else {
            Node newNode = new Node(value);
            if (map.size() == capacity) {
                Node prevNode = tail.prev;
                map.remove(tail.data);
                removeNode(tail);
                tail = prevNode;
            }
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    public void addNode(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void removeNode(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        if (prevNode != null)
            prevNode.next = nextNode;
        if (nextNode != null)
            nextNode.prev = prevNode;
    }

    public int updateNode(Node node, int data) {
        if (node.prev != null)
            node.prev.next = node.next;
        if (node.next != null)
            node.next.prev = node.prev;
        node.prev = null;
        node.next = head;
        if (data != -1) {
            node.data = data;
        }
        head = node;
        return node.data;
    }
}
