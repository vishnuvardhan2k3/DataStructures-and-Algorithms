package leetcode;

import java.util.ArrayList;

import java.util.Scanner;

public class Permutationofarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
			ArrayList<ArrayList<Integer>>result=permute(a);
		for(ArrayList<Integer>i:result) {
			System.out.println(i);
		}
		sc.close();
	}

	private static ArrayList<ArrayList<Integer>> permute(int[] a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		permutate(list,new ArrayList<>(),new boolean[a.length],a);
		return list;
		
	}
	static void  permutate(ArrayList<ArrayList<Integer>>list,ArrayList<Integer>temp,boolean[]used,int []a) {
		if(temp.size()==a.length) {
			list.add(new ArrayList<>(temp));
			return;
		}
		
		
		for(int i=0;i<used.length;i++) {
			if(used[i])continue;
			used[i]=true;
			temp.add(a[i]);
			permutate(list,temp,used,a);
			used[i]=false;
			temp.remove(temp.size()-1);
		}
	}


}
