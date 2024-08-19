package tw.test.tutor;

import java.util.Scanner;

public class grade {

	public static void main(String[] args) {
		double score = Math.floor(Math.random()*100);
		System.out.println((int)score);
		if(score>=90) System.out.println("A");
		else if(score>=80) System.out.println("B");
		else if(score>=70) System.out.println("C");
		else if(score>=60) System.out.println("D");
		else System.out.println("E");
	}

}
