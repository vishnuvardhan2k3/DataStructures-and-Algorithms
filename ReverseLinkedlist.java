package leetcode;

import java.util.Scanner;

public class ReverseLinkedlist {
	static class ListNode{
		int num;
		ListNode next;
		public ListNode(int num) {
			super();
			this.num = num;
		}
	}
	ListNode head;
	private  void Createlist(Scanner sc) {
		System.out.print("Enter number of elements:");
		int n=sc.nextInt();
		ListNode it=null;
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			ListNode node= new ListNode(num);
			if(head==null) {
				head=node;
				it=head;
			}
			else
			{
				it.next=node;
				it=it.next;
				
			}
		}
		
	}
	private void reverse() {
		ListNode curr=head;
		ListNode prev=null;
		while(curr!=null) {
			ListNode next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
	}
	void printlist() {
		ListNode curr=head;
		while(curr!=null) {
			System.out.print(curr.num);
			curr=curr.next;
		}	
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReverseLinkedlist rl = new ReverseLinkedlist();
		rl.Createlist(sc);
		System.out.print("Original list:");
		rl.printlist();
		
		System.out.print("Reversed list:");
		rl.reverse();
		rl.printlist();
	}
	
}
