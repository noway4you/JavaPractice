package tw.test.poker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ten_thirty {

	public static void main(String[] args) {
		int[] cards = new int[13];
		int[][] players = new int[4][2];
		double[] res = new double[4];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				while(true) {
					int r = (int)(Math.random()*13);
					if(cards[r]<=4) {
						players[i][j] = r+1;
						cards[r]++;
						break;
					}
				}
			}
		}
		
		for(int i=0;i<4;i++) {
			double sum = 0;
			for(int j=0;j<2;j++) {
				int nums = players[i][j];
				if(nums==11||nums==12||nums==13) sum+=0.5;
				else sum+=nums;
			}
			if(sum>10.5) res[i] = 11;
			else res[i] = 10.5-sum;
		}
		
		int winner = 0;
		for(int i=0;i<4;i++) {
			System.out.println("Player"+(i+1)+" : "+res[i]);
			double temp = res[0];
			if(temp > res[i]) {
				winner = i;
				temp = res[i];
			}
		}
		System.out.println("------------------------");
		System.out.println("Winner is player"+(winner+1)+"\nLowest difference = "+res[winner]);
	}

}
