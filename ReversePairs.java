package leetcode;

import java.util.Scanner;

public class ReversePairs {
	
	static void merge(int[]a,int left,int right,int mid){
		int []merged=new int[right-left+1];
		int ind1=left;
		int ind2=mid+1;
		int x=0;
		while(ind1<=mid&&ind2<=right) {
			if(a[ind1]<a[ind2]) {
				merged[x++]=a[ind1++];
			}
			else {
				merged[x++]=a[ind2++];
			}
		}
		while(ind1<=mid) {
			merged[x++]=a[ind1++];
		}
		while(ind2<=right) {
			merged[x++]=a[ind2++];
		}
		
		for(int i=0,j=left;i<merged.length;i++,j++){
			a[j]=merged[i];
			
		}	
	}
	static int countpairs(int a[],int low,int high,int mid){
		int pointer=mid+1;
		int count=0;
		
		for(int i=low;i<=mid;i++) {
			while(pointer<=high&&a[i]>2*a[pointer]) {
				pointer++;
				}
			count+=(pointer-(mid+1));
			}
		return count;
		}
	static int divide(int[] a,int left,int right) {
		int count=0;
		if(left>=right)return count;
		int mid=left+(right-left)/2;
		count+=divide(a,left,mid);
		count+=divide(a,mid+1,right);
		count+=countpairs(a,left,right,mid);
		merge(a,left,right,mid);
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=sc.nextInt();
		}
		// [1 3 2 3 1] nums[1] = 3, nums[4] = 1, 3 > 2 * 1 ||  (3, 4) --> nums[3] = 3, nums[4]=1 3>2*1 result ==> 2
		
		System.out.println(divide(nums,0,n-1));
		sc.close();
	}
}
