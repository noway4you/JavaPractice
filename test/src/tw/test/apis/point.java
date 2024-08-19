package tw.test.apis;

import java.io.Serializable;

public class point implements Serializable{
	private int x,y;
	
	public point(int x,int y) {
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
