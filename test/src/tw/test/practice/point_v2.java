package tw.test.practice;

import java.io.Serializable;

public class point_v2 implements Serializable{
	private int x,y;
	
	public point_v2(int x,int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
