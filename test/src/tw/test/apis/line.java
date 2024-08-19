package tw.test.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;

public class line implements Serializable{
	private Color color;
	private float width;
	private LinkedList<point> line;
	private LinkedList<point> line2;
	
	public line(Color color,float width) {
		this.color = color;
		this.width = width;
		line = new LinkedList<>();
		line2 = new LinkedList<>();		
	}
	
	public Color getColor() {
		return color;
	}
	public float getWidth() {
		return width;
	}
	public void add_point(point point) {
		line.add(point);
	}
	public point get_point(int index) {
		return line.get(index);
	}
	public int get_size() {
		return line.size();
	}
	
}
