package tw.test.tutor;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		while(true) {
			// input
			Scanner op = new Scanner(System.in);
			System.out.print("choose operation:");
			String str = op.nextLine();
			if(!(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/"))) {
				System.out.println("Wrong operation keywords!");
				continue;
			}
			Scanner sc1 = new Scanner(System.in);
			System.out.print("input first number:");
			int num1 = sc1.nextInt();
			Scanner sc2 = new Scanner(System.in);
			System.out.print("input second number:");
			int num2 = sc2.nextInt();
			// operation
			int res = 0;
			int mod = 0;
			boolean check = true;
			if(str.equals("+")) res = num1+num2;
			else if(str.equals("-")) res = num1-num2;
			else if(str.equals("*")) res = num1*num2;
			else if(str.equals("/")) {
				if(num2 == 0) check = false;
				else {
					res = num1/num2;
					mod = num1%num2;
				}
			}
			//output
			if(!check) System.out.println("answer = undefined");
			else if(mod!=0) {
				System.out.println("answer = " + res + "..." + mod);
			}else {
				System.out.println("answer = " + res);
			}
			//check again?
			Scanner ag = new Scanner(System.in);
			System.out.print("Quit(end or any)? ");
			String str2 = ag.nextLine();
			if(str2.equals("end")) break;
		}
	}

}
