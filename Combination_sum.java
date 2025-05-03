package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Combination_sum {
	
	static class Solution {
	    public List<List<Integer>> combinationSum(int[] a, int target) {
	        List<List<Integer>>result=new ArrayList<>();
	        allpossiblecombinations(result,a,target,0,new ArrayList<>(),0);
	        return result; 
	    }
	     void allpossiblecombinations(List<List<Integer>> result,int []a,int target,int sum,List<Integer>list,int start){
	        if(sum==target){
	            result.add(new ArrayList<Integer>(list));
	        }
	        else if(sum>target)return;
	        for(int i=start;i<a.length;i++){
	            if(a[i]>target)continue;
	            if (i > start && a[i] == a[i - 1]) continue;
	            list.add(a[i]);
	            allpossiblecombinations(result,a,target,sum+a[i],list,i);
	            list.remove(list.size()-1);
	        }
	     }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Size of Array:");
		int n=sc.nextInt();
		System.out.println("Enter Elements:");
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		System.out.print("Enter target:");
		int k=sc.nextInt();
		Solution sol=new Solution();
		System.out.println(sol.combinationSum(a,k));
		sc.close();
	}

}
