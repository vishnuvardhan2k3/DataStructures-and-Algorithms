package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Combination_sum_II {
	
	    static List<List<Integer>> combinationSum2(int[] nums, int target) {
	        Arrays.sort(nums);
	        List<List<Integer>> result=new ArrayList<>();
	        allpossible(nums,target,result,new ArrayList<>(),0,0);
	        return result;
	    }
	   static void allpossible(int []nums,int k,List<List<Integer>>result,List<Integer>list,int sum,int start){
	        if(sum==k){
	            
	            result.add(new ArrayList<>(list));
	            
	            return;
	        }
	        if(sum>k)return;
	        
	        for(int i=start;i<nums.length;i++){
	            if (i > start && nums[i] == nums[i - 1]) continue;
	            if (nums[i] > k) break;
	            list.add(nums[i]);
	            allpossible(nums,k,result,list,sum+nums[i],i+1);
	            list.remove(list.size()-1);
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
		System.out.println(combinationSum2(a,k));
		sc.close();
	}

}
