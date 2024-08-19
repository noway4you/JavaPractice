package tw.test.tutor;

public class poker_game {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		//4 player giving with 13th zero array
		int[][] player = new int[4][13];
		// array with index 0~51 represent 52 cards of poker
		int[] poker = new int[52];  
		// giving 13 numbers to 4 player's array
		for(int i=0;i<4;i++) {
			// get 13 non-repeat number from 0~51
			for(int j=0;j<13;j++) {
				//check if repeat
				while(true) {
					int r = (int)(Math.random()*52);
					if(poker[r]==0) {
						player[i][j] = r;
						poker[r]++;
						break;
					}
				}
			}
		}
		// print 
		int count = 0;
		for(int i=0;i<4;i++) {
			System.out.print("Player"+(i+1)+" : ");
			for(int j=0;j<13;j++) {
				if(player[i][j]/13==0) System.out.print("黑桃"+(player[i][j]+1)); 
				else if(player[i][j]/13==1) System.out.print("紅心"+(player[i][j]-12));
				else if(player[i][j]/13==2) System.out.print("方塊"+(player[i][j]-25));
				else if(player[i][j]/13==3) System.out.print("梅花"+(player[i][j]-38));
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(System.currentTimeMillis()-start + "ms");
	}

}
