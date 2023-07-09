package hotBack;

/**
 * @author fouthed
 * @date 2023/6/15
 */
public class LinkedListSort {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);

        int[] arr = new int[]{2, 1, 3, 5};
        ListNode p = head;
        for (int n : arr) {
            p.next = new ListNode(n);
            p = p.next;
        }

        ListNode ret = sort(head, null);
        StringBuffer buffer = new StringBuffer();
        while (ret != null) {
            buffer.append(ret.val + ",");
            ret = ret.next;
        }
        System.out.println(buffer.toString());

    }

    public static ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode l1 = sort(mid, tail);
        ListNode l2 = sort(head, mid);
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = merge(l1, l2);
        return dummyHead.next;

    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummyHead.next;
    }
}
