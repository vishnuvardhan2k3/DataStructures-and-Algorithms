package leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import leetcode.ReverseLinkedlist.ListNode;

public class Floyds_tortoise_and_Hare_algorithm_for_finding_startingnode {
	
	static ListNode head;
	static ListNode iterator;
	
	@SuppressWarnings("unused")
	static void createlist(Scanner sc){
		int nodes=sc.nextInt();
		HashMap<ListNode,Integer>map=new HashMap<>();
		
		int n=1;
		
		for(int i=0;i<nodes;i++) {
			int val=sc.nextInt();
			ListNode node=new ListNode(val);
			map.put(node,n);
			n++;
			if(head==null) {
				head=node;
				iterator=node;
			}
			else {
				iterator.next=node;
				iterator=node;	
			}
		}
		System.out.print("Enter to ehich node it is to be connected:");
		int cycle=sc.nextInt(); //just for creating the cycle it is not the process
		for(Map.Entry<ListNode,Integer>i:map.entrySet()) {
			if(i.getValue()==cycle) {
				iterator.next=i.getKey();
			}
		}
		
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
		if(fast==null)return null;
			
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
