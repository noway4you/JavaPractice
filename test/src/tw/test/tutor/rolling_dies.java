package tw.test.tutor;

public class rolling_dies {

	public static void main(String[] args) {
		int[] count = new int[6];
		for(int i=0;i<100;i++) {
			int r = (int)(Math.random()*6+1);
			count[r-1]++;
		}
		for(int i=0;i<count.length;i++) System.out.println((i+1)+" : "+count[i]+" times");
	}

}
