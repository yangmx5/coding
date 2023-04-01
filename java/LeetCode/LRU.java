package LeetCode;

import java.util.Hashtable;

class LRUCache {

    class DLinkNode {
        public int val;
        public int key;
        public DLinkNode pre;
        public DLinkNode next;
    }

    public DLinkNode head;
    public DLinkNode tail;

    private void addNode(DLinkNode node) {
        node.next = head.next;
        node.pre = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void move_to_head(DLinkNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkNode pop_tail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;
    }

    private int size;
    private int cap;
    private Hashtable<Integer, DLinkNode> cache = new Hashtable<Integer, DLinkNode>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
    }

    public int get(int key) {
        DLinkNode ret = cache.get(key);
        if (ret == null) {
            return -1;
        } else {
            move_to_head(ret);
            return ret.val;
        }
    }

    public void put(int key, int value) {
        DLinkNode tmp = new DLinkNode();
        tmp.key = key;
        tmp.val = value;
        DLinkNode ret = cache.get(key);
        if (ret == null) {
            addNode(tmp);
            cache.put(0, tmp);
            size++;
            if (size > cap) {
                DLinkNode tmp2 = pop_tail();
                removeNode(tmp2);
                cache.remove(tmp2);
                size--;
            } else {
                move_to_head(tmp);
            }
        } else {
            ret.val = tmp.val;
            move_to_head(ret);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
