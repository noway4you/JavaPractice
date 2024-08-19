package tw.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class spiral_matrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many rows?");
		int rows = sc.nextInt();
		System.out.print("How many columns?");
		int columns = sc.nextInt();
		int[][] matrix = new int[rows][columns];
		for(int i=0;i<rows;i++) {
			System.out.println("Row"+(i+1)+":");
			for(int j=0;j<columns;j++) {
				System.out.print("number"+(j+1)+" = ");
				int nums = sc.nextInt();
				matrix[i][j] = nums;
			}
		}
		System.out.println("-------------------------------");
		System.out.println("Spiral Matrix = " + spiralOrder(matrix));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        while(true) {
        	for(int i=left;i<=right;i++) res.add(matrix[top][i]);
        	top++;
        	if(top > bottom) break;
        	for(int i=top;i<=bottom;i++) res.add(matrix[i][right]);
        	right--;
        	if(left > right) break;
        	for(int i=right;i>=left;i--) res.add(matrix[bottom][i]);
        	bottom--;
        	if(top > bottom) break;
        	for(int i=bottom;i>=top;i--) res.add(matrix[left][i]);
        	left++;
        	if(left > right) break;
        }
        
        return res;
    }

}
