package hotBack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fouthed
 * @date 2023/6/15
 */
public class LRUCache {
    public static class ListNode {
        public int key;
        public int val;
        public ListNode pre;
        public ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static Map<Integer, ListNode> map = new HashMap<>();
    public static ListNode head = new ListNode(-1, -1);
    public static ListNode tail = new ListNode(-1, -1);
    public static int size = 0;
    public static int cap = 2;

    public LRUCache() {
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.put(1,2);
        cache.put(2,4);
        System.out.println(cache.get(2));
        cache.put(3,6);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));


    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        ListNode node = map.get(key);
        if(node != null){
            node.val = val;
            moveToHead(node);
        }else {
            ListNode newNode = new ListNode(key, val);
            addToHead(newNode);
            map.put(key, newNode);
            size++;
            if (size >= cap) {
                ListNode remove = removeTail();
                map.remove(remove.key);
                size--;
            }
        }
    }

    public void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(ListNode node) {
        head.next.pre = node;
        node.pre = head;
        node.next = head.next;
        head.next = node;
    }

    public ListNode removeTail() {
        ListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
