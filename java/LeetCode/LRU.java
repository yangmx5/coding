class LRUCache {

    class DLinkNode{
        int val;
        int key;
        DLinkNode pre;
        DLinkNode next;
    }
    private DLinkNode head;
    private DLinkNode tail;

    private void addNode(DLinkNode node){
        node.next = head.next;
        node.pre = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void move_to_head(DLinkNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkNode pop_tail(){
        node = tail.pre;
        removeNode(node);
    }

    private int size;
    private int cap;
    private Hashtable<Integer,DLinkNode> cache = new Hashtable<Integer, DLinkNode>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
    }
    
    public int get(int key) {
        DLinkNode ret = cache.get(key);
        if(ret == null){
            return -1;
        }else{
            move_to_head(ret);
            return ret.value;
        }
    }
    
    public void put(int key, int value) {
        DLinkNode tmp = new DLinkNode();
        tmp.key = key;
        tmp.value = value;
        DLinkNode ret = cache.get(key);
        if(ret == null){
            addNode(tmp);
            cache.put(tmp);
            size++;
            if(size > cap){
                DLinkNode tmp = pop_tail();
                removeNode(tmp);
                cache.remove(tmp);
                size--;
            }else{
                move_to_head(tmp);
            }
        }else{
            ret.value = tmp.value;
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
