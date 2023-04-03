package hotOneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2023/4/3
 */
public class LRU {

    class ListNode {
        public int value;
        public int key;
        public ListNode pre;
        public ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int size;
    int capacity;


    public LRU() {
        size = 0;
        capacity = 5;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRU cache = new LRU();
        cache.set(1, 2);
        cache.printCache();
        cache.set(2, 3);
        cache.printCache();
        cache.set(3, 3);
        cache.printCache();
        cache.set(4, 3);
        cache.printCache();
        cache.set(5, 3);
        cache.printCache();

        cache.get(1);
        cache.printCache();

        cache.set(6, 3);
        cache.printCache();

    }

    public int get(Integer key) {
        ListNode node = map.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public int set(Integer key, Integer value) {
        if (capacity <= size) {
            ListNode last = removeTail();
            map.remove(last.key);
            size--;
        }

        ListNode node = new ListNode(key, value);
        addToHead(node);
        map.put(key, node);
        size++;
        return value;
    }

    public ListNode removeTail() {
        ListNode ret = tail.pre;
        ret.next = null;
        tail.pre = ret.pre;
        ret.pre = null;
        tail.pre.next = tail;
        return ret;
    }

    public void addToHead(ListNode node) {
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }

    public void removeFromList(ListNode node) {
        if (node.pre != null && node.next != null) {
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
        }
    }

    public void moveToHead(ListNode node) {
        removeFromList(node);
        addToHead(node);
    }

    public void printCache() {
        ListNode p = head;
        StringBuffer buffer = new StringBuffer();
        while (p != null) {
            buffer.append("{" + p.key + ":" + p.value + "},");
            p = p.next;
        }
        System.out.println(buffer.toString());
    }

}
