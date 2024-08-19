package tw.test.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class spiral_matrix2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many rows?");
		int row = sc.nextInt();
		System.out.print("How many columns?");
		int column = sc.nextInt();
		int[] arr = new int[row*column];
		System.out.println("Create array :");
		for(int i=0;i<arr.length;i++) {
			System.out.print("number"+(i+1)+" = ");
			int nums = sc.nextInt();
			arr[i] = nums;
		}
		System.out.println("-------------------");
		
		generateMatrix(arr,row,column);
	}
	
	public static void generateMatrix(int[] arr , int row , int column) {
        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right = column-1;
        int k = 0;
        int[][] matrix = new int[row][column];
        
        while(true) {
        	for(int i=left;i<=right;i++) {
        		matrix[top][i] = arr[k];
        		k++;
        	}
        	top++;
        	if(top > bottom) break;
        	for(int i=top;i<=bottom;i++) {
        		matrix[i][right] = arr[k];
        		k++;
        	}
        	right--;
        	if(left > right) break;
        	for(int i=right;i>=left;i--) {
        		matrix[bottom][i] = arr[k];
        		k++;
        	}
        	bottom--;
        	if(top > bottom) break;
        	for(int i=bottom;i>=top;i--) {
        		matrix[i][left] = arr[k];
        		k++;
        	}
        	left++;
        	if(left > right) break;
        }
        
        for(int i=0;i<row;i++) {
        	for(int j=0;j<column;j++) {
        		System.out.print(matrix[i][j]+" ");
        	}
        	System.out.println();
        }
    }
}
