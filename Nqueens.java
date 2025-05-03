package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	
	
	void placingqueens(int n, char[][] queens,int row,List<List<String>>allboards){
        if(row==n){                              //if recursion occurs beyond the length last row it means it is possible condition
            addingboard(queens,allboards);
            return;
        }

        for(int i=0;i<n;i++){                   // it checks all position in 1st a row by placing queens one after the other 
            if(issafe(row,i,n,queens)){         // checking condition whether the position is safe r not
                queens[row][i]='Q';
                placingqueens(n,queens,row+1,allboards); //after placing in 1st row checking other rows safe/not 
                queens[row][i]='.';                         //finding for another solution back tracking

            }
        }
    }
	
    boolean issafe(int row ,int col,int n,char[][]queens){// helper function to determine it is safe position or not
        //upleft diagonal
         for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(queens[i][j]=='Q'){
                return false;
            }
        }

        //upright diagonal
        for(int i=row,j=col;i>=0&&j<n;i--,j++){
            if(queens[i][j]=='Q'){
                return false;
            }
        }

        //down left diagonal
         for(int i=row,j=col;i<n&&j>=0;i++,j--){
            if(queens[i][j]=='Q'){
                return false;
            }
        }

        //down right diagonal

         for(int i=row,j=col;i<n&&j<n;i++,j++){
            if(queens[i][j]=='Q'){
                return false;
            }
        }
        //columns
        for(int i=0;i<n;i++){
            if(queens[i][col]=='Q')return false;
        }
        // rows are not needed because we are checking only once for row

        return true;



    }
    
   void addingboard(char[][]queens,List<List<String>> result){ // adding board to result
        List<String> list=new ArrayList<>();
      for(int i=0;i<queens.length;i++){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<queens.length;j++){
            char c=(queens[i][j]=='Q')?'Q':'.';
            sb.append(c);
            }
            list.add(sb.toString());

      }
        result.add(list);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>allboards=new ArrayList<>();
        char[][] queens=new char[n][n];
        placingqueens(n,queens,0,allboards);
        return allboards;
    }
}

public class Nqueens {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		char[][]a=new char[n][n];
		Solution s = new Solution();
		List<List<String>>list=new ArrayList<>();
		s.placingqueens(n, a, 0, list);
		for(List<String>i:list) {
			System.out.println(i);
		}
		sc.close();
		
	}

}
