package hotOneHundred;

/**
 * @date 2023/3/30
 */
public class ListNodeIntegerAdd {

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }


    }

    public static ListNode genLinkedList(int[] arr) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode p = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            p.next = new ListNode(arr[i], null);
            p = p.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 9, 4};
        int[] arr2 = new int[]{1, 2, 9, 9};
        ListNode head = genLinkedList(arr);
        ListNode head2 = genLinkedList(arr2);

        ListNode revert1 = reverseLinkedList(head);
        ListNode revert2 = reverseLinkedList(head2);

        ListNode ret = reverseLinkedList(mergerList(revert1, revert2));
        printLinkedList(ret);

    }

    public static ListNode mergerList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode p = dummyHead;
        int mod = 0;
        while (l1 != null && l2 != null) {
            int v = l1.value + l2.value + mod;
            mod = v / 10;
            v = v % 10;
            ListNode node = new ListNode(v, null);
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummyHead.next;
    }

    public static void printLinkedList(ListNode listNode) {
        ListNode p = listNode;
        StringBuffer buffer = new StringBuffer();
        while (p != null) {
            buffer.append(p.value + ",");
            p = p.next;
        }
        System.out.println(buffer.toString());
    }

    public static ListNode reverseLinkedList(ListNode listNode) {
        ListNode curr = listNode, pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;

    }
}
