package tw.test.tutor;

import java.util.ArrayList;
import java.util.Collections;

public class poker_game_3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// Linked List + shuffle function
		ArrayList<Integer> poker = new ArrayList<Integer>();
		for(int i=0;i<52;i++) poker.add(i);
		Collections.shuffle(poker);
		
		String[] suits = {"黑桃","紅心","方塊","梅花"};
		String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int count = 0;
		System.out.print("Player"+(count+1)+" : ");
		for(int i:poker) {
			System.out.print(suits[i/13]+" "+values[i%13]+"\t");
			count++;
			if(count%13==0 && count/13<4) System.out.print("\nPlayer"+(count/13+1)+" : ");
		}
		System.out.println();
		System.out.println(System.currentTimeMillis()-start + "ms");
	}

}
