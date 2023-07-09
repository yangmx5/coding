package hotBack;

/**
 * @author fouthed
 * @date 2023/6/15
 */
public class LinkedListDetectCircle {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode sec = new ListNode(2);
        head.next = sec;
        ListNode zero = new ListNode(0);
        sec.next = zero;
        ListNode four = new ListNode(-4);
        zero.next = four;
        four.next = zero;

        ListNode node = detectCircle(head);
        System.out.println(node.val);
    }

    public static ListNode detectCircle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
