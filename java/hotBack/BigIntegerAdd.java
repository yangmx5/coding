package hotBack;

/**
 * @author fouthed
 * 链表大数相加
 * @date 2023/6/7
 * 两个链表逆序，相加，再逆序
 * 注意两个链表不等长，对余数的处理
 */
public class BigIntegerAdd {

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 4, 3};
        int[] arr2 = new int[]{1, 2, 3};
        ListNode l1 = genLinkedList(arr1);
        ListNode l2 = genLinkedList(arr2);
        printLinkedList(l1);
        printLinkedList(l2);

        ListNode p1 = reverse(l1);
        ListNode p2 = reverse(l2);
        int mod = 0;
        ListNode ret = new ListNode(-1);
        ListNode p = ret;
        while (p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.value;
            int v2 = p2 == null ? 0 : p2.value;
            int value = v1 + v2 + mod;
            mod = value / 10;
            value %= 10;
            p.next = new ListNode(value);
            p = p.next;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }
        if (mod != 0) {
            p.next = new ListNode(mod);
        }

        printLinkedList(ret);

        ret = reverse(ret.next);

        printLinkedList(ret);
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static ListNode genLinkedList(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int i = 0; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void printLinkedList(ListNode head) {
        StringBuffer buffer = new StringBuffer();
        while (head != null) {
            buffer.append(head.value + ",");
            head = head.next;
        }
        System.out.println(buffer.toString());
    }

}
