package tw.test.tutor;

import java.util.Scanner;

public class leap_year {

	public static void main(String[] args) {
		System.out.print("Enter the years : ");
		Scanner sc = new Scanner(System.in);
		int now = sc.nextInt();
		int count = 0;
		for(int i = 1;i<=now;i++) {
			int year = i;
			boolean check = false;
			if(year%4==0) {
				if(year%100==0) {
					if(year%400==0) check = true;
				}else check = true;
			}
			if(check) {
				System.out.println(year);
				count++;
			}
		}
		System.out.println("Leap year in 1~"+now+" : "+count);
	}

}
