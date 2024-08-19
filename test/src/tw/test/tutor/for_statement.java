package tw.test.tutor;

import java.util.Scanner;

public class for_statement {

	public static void main(String[] args) {
		System.out.print("Enter the start : ");
		Scanner start = new Scanner(System.in);
		int st = start.nextInt();
		System.out.print("Enter the end : ");
		Scanner end = new Scanner(System.in);
		int ed = end.nextInt();
		if(st>ed) System.out.println("Error!");
		else {
			for(int i=st;i<=9;i++) {
				for(int j=st;j<=ed;j++) {
					System.out.print(j+" X "+i+" = "+i*j+"\t");
				}
				System.out.println();
			}
		}
	}
}
