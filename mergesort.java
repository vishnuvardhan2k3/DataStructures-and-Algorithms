
package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class mergesort {
	void divide(int[] a, int si, int ei) {
		int mid=si+(ei-si)/2;
		if(si>=ei) {
			return;
		}
		divide(a,si,mid);
		divide(a,mid+1,ei);
		merge(a,si,mid,ei);
	}
	private void merge(int[] a, int si, int mid, int ei) {
		int sorted[]=new int[ei-si+1];
		int index1=si;
		int index2=mid+1;
		int x=0;
		while(index1<=mid&&index2<=ei) {
			if(a[index1]<=a[index2]) {
				sorted[x++]=a[index1++];
				
			}
			else {
				sorted[x++]=a[index2++];
			}
		}
		while(index1<=mid) {
			sorted[x++]=a[index1++];
		}
		while(index2<=ei) {
			sorted[x++]=a[index2++];
		}
		for(int i=0,j=si;i<sorted.length;i++,j++) {
			a[j]=sorted[i];
			
		}
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		{
			a[i]=sc.nextInt();
		}
		sc.close();
		mergesort mg = new mergesort();
		mg.divide(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
}
