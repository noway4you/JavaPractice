package tw.test.leetcode;

import java.util.Scanner;

// print the number of the number and its repeats times >> ex: n = 1121 --> output = 211211
public class count_and_say {

	public static void main(String[] args) {
		// given input number >> n --> doing nth times
		System.out.print("Enter the count number = ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Say = "+say(n));
	}
	
	public static String say(int n) {
		if(n==0) return "0";
		else if(n==1) return "1";
		else {
			// if n>0 , always start with "1"
			String s = "1";
			// doing methods nth times
			for(int i=1;i<n;i++) {
				StringBuilder sb = new StringBuilder();
				int j = 0;
				while(j < s.length()) {
					int count = 0;
					int t = j;
					char c = s.charAt(j);
					// check the number of its repeating times
					while(t < s.length() && s.charAt(t) == c) {
						count++;
						t++;
					}
					// append the number of its repeating times and the number
					sb.append(String.valueOf(count));
					sb.append(c);
					j = t;
				}
				s = sb.toString();
			}
			return s;
		}
	}

}
