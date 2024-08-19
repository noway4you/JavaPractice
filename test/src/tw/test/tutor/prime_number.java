package tw.test.tutor;

import java.util.Scanner;

public class prime_number {

	public static void main(String[] args) {
		System.out.print("Enter the last numbers:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		boolean check = true;
		for(int i=1;i<=num;i++) {
			if(i!=1 && i!=2 && i%2!=0) {
				for(int j=3;j<i;j+=2) {
					if(i%j==0) {
						check = false;
						break;
					}
				}
				if(check) System.out.format("\033[31m"+i+"\t\033[0m");
				else System.out.print(i+"\t");
			}
			else {
				System.out.print(i+"\t");
			}
			if(i%10==0) System.out.println();
		}
	}

}
