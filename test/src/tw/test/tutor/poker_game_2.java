package tw.test.tutor;

public class poker_game_2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		int[][] player = new int[4][13];
		for(int i=0;i<52;i++) {
			poker[i] = i+1;
		}
		int count = 52;
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				int r = (int)(Math.random()*(count));
				player[i][j] = poker[r];
				int temp = poker[r];
				poker[r] = poker[count-1];
				poker[count-1] = temp;
				count--;
			}
		}
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
