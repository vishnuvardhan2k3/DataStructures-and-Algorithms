package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import leetcode.ReverseLinkedlist.ListNode;

public class Floyds_tortoise_and_Hare_algorithm_for_size_of_loop {
	static ListNode head;
	static ListNode iterator;
	
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
		System.out.print("Enter to Which node it is to be connected:");
		int cycle=sc.nextInt(); //just for creating the cycle it is not the process 
		for(Map.Entry<ListNode,Integer>i:map.entrySet()) {
			if(i.getValue()==cycle) {
				iterator.next=i.getKey();
			}
		}
		
	}
	static int size(ListNode head) {
		
		ListNode slow=head,fast=head;
		
		while(fast!=null && fast.next !=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				int size=1;
				fast=fast.next;
				while(fast!=slow) {
					size++;
					fast=fast.next;
				}
				return size;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		createlist(sc);
		int size=size(head);
		if(size==-1)System.out.println("Cycle not found!!");
		else {
			System.out.println(size);
		}
	}
}
