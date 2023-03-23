package forwardoffer;

import java.awt.List;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import org.junit.Test;

import entities.ListNode;


/*
 * 删除链表中重复元素
 * 
 */
public class DeleteDuplication {

	public ListNode deleteDuplication(ListNode pHead) {

		ListNode first = new ListNode(-1);
        first.next = pHead;
        
        ListNode p = first;
        
        
       
        
        
        while(p.next.next != null){
            if(p.next.val == p.next.next.val){
              ListNode p2 = p.next;
              while(p2.val == p2.next.val){
                  p2 = p2.next;
              }
           //   p.val = p2.next.val;
              p.next = null;
              p.next = p2.next;
            }else{ 
                p = p.next;        
            }
        }
        
        return pHead;
	}

	@Test
	public void test() {
		
		String [] a = new String[]{"1","2"};
		
		System.out.println(a.getClass());
		 
		ListNode[] list = new ListNode[7];
		ListNode pHead = new ListNode(1);
		list[0] = pHead;
		for (int i = 1; i < 7; i++) {
			ListNode Node = new ListNode(i+1);
			list[i] = Node;
		}

		for (int i = 0; i < 7; i++) {
			try {
				list[i].next = list[i + 1];
			} catch (Exception err) {
			}
		}
		
		
		list[3].val = 3;
		list[4].val = 4;
		list[5].val = 4;
		list[6].val = 5;
		
		ListNode p1 = pHead;
		while(p1 != null){
			System.out.println(p1);
			p1=p1.next;
		}
		System.out.println("--");
		
		deleteDuplication(pHead);
		
		ListNode p = pHead;
		while(p != null){
			System.out.println(p);
			p=p.next;
		}

		
	}

}
