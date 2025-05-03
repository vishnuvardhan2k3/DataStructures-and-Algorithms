package sorting;

import java.util.Arrays;
import java.util.Scanner;


public class Quicksort {
	static void qs(int a[],int l,int r){
		if(l<r) {
		int pi=partition(a,l,r);
		qs(a,l,pi-1);
		qs(a,pi+1,r);
		}
	}
	private static int partition(int[] a, int l, int h) {
		// TODO Auto-generated method stub
		int pi=a[l];
		int i=l;
		int j=h;
		while(i<j) {
			while(i<=h && a[i]<=pi) {
				i++;
			}
			while(j>=l && a[j]>pi) {
				j--;
			}
			if(i<=j) {
				swap(a,i,j);
				i++;
				j--;
			}
		}
		
		swap(a,l,j);
		return j;
	}
	static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
			
		}
		sc.close();
		qs(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
