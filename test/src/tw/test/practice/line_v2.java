package tw.test.practice;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;

public class line_v2 implements Serializable{
	private Color color;
	private float width;
	private LinkedList<point_v2> line;
	
	public line_v2(Color color,float width) {
		this.color = color;
		this.width = width;
		line = new LinkedList<>();		
	}
	
	public Color getColor() {
		return color;
	}
	public float getWidth() {
		return width;
	}
	public void add_point(point_v2 point) {
		line.add(point);
	}
	public point_v2 get_point(int index) {
		return line.get(index);
	}
	public int get_size() {
		return line.size();
	}
	
}
