package hotOneHundred;

import java.util.Arrays;
import java.util.List;

/**
 * @date 2023/3/27
 * <p>
 * 链表排序
 */
public class LinkListSort {

    static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static ListNode genListNodeList(List<Integer> arr) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode p = dummyHead;
        for (int n : arr) {
            p.next = new ListNode(n, null);
            p = p.next;
        }
        return dummyHead.next;
    }

    public static void printListNode(ListNode node) {
        StringBuilder builder = new StringBuilder();
        ListNode p = node;
        while (p.next != null) {
            builder.append(p.value).append(",");
            p = p.next;
        }
        builder.append(p.value);
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ListNode head = genListNodeList(Arrays.asList(2, 3, 4, 5, 1));
        ListNode ret = sort(head, null);
        printListNode(ret);
    }

    /**
     * 自顶向下的归并排序
     *
     * @param head
     */
    public static ListNode sort(ListNode head, ListNode tail) {
        int len = 0;
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode f = head, s = head;
        while (f != tail) {
            f = f.next;
            s = s.next;
            if (f != tail) {
                f = f.next;
            }
        }
        ListNode m = s;
        ListNode list1 = sort(head, m);
        ListNode list2 = sort(m, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1, null);
        ListNode i = dummyHead, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                i.next = p1;
                p1 = p1.next;
            } else {
                i.next = p2;
                p2 = p2.next;
            }
            i = i.next;
        }
        if (p1 != null) {
            i.next = p1;
        }
        if (p2 != null) {
            i.next = p2;
        }
        return dummyHead.next;
    }

}
