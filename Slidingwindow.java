package leetcode;

import java.util.Scanner;
// min/max sum of subarray of k length
public class Slidingwindow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		int sum=0;
		for(int i=0;i<k;i++) {
			sum+=a[i];
		}
		int min=sum;// int max=sum
		for(int i=k;i<a.length;i++) {
			sum=sum+a[i]+a[i-k];
			//min sum
			if(sum<min) {
				min=sum;
			}
			/*max sum
			if(sum>max) {
				max=sum;
			}*/
		}
		System.out.println(min);
		sc.close();
	}

}
