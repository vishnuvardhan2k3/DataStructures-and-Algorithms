package leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import leetcode.ReverseLinkedlist.ListNode;

public class Floyds_tortoise_and_Hare_algorithm_for_finding_startingnode {
	
	static ListNode head;
	static ListNode iterator;
	
	static void createlist(Scanner sc){
		int nodes=sc.nextInt();
		System.out.println("Enter cycle position:");
		int cyclepos= sc.nextInt();
		ListNode cyclenode=null;
	
		
		for(int i=0;i<nodes;i++) {
			int val=sc.nextInt();
			ListNode node=new ListNode(val);
			if(i+1==cyclepos)cyclenode=node;
			if(head==null) {
				head=node;
				iterator=node;
			}
			else {
				iterator.next=node;
				iterator=node;	
			}
		}
		iterator.next=cyclenode;
		
	}
	
	private static ListNode startingnode(ListNode head) {
		// TODO Auto-generated method stub
		ListNode fast=head,slow=head;
		while(fast!=null && fast.next!=null ){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				break;
			}
		}
		if(fast==null|| fast.next==null)return null;
			
		slow=head;
			
		while(fast!=slow) {
				slow=slow.next;
				fast=fast.next;
			}
		
		return slow;
	}
	
	private static int indexofresult(ListNode res, ListNode head2) {
		// TODO Auto-generated method stub
		if(res==null)return -1;
		ListNode curr=head;
		int count=0;
		while(curr!=res) {
			curr=curr.next;
			count++;
		}
		return count;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		createlist(sc);
		ListNode resultantnode=startingnode(head);
		System.out.println(indexofresult(resultantnode,head));
		
	}
		

}
