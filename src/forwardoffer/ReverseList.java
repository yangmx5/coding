package forwardoffer;

import entities.ListNode;

public class ReverseList {

	
	public ListNode ReverseListSolution(ListNode head){
		
		ListNode result = null;
		ListNode pre  = null;
		ListNode current = head;
		ListNode next = head.next;
		
		while(current !=null){
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
			if(next == null)
				result = current;
		}
		return result;
	}
	
	public static void main(String[] args) {
			
	} 
	
}
