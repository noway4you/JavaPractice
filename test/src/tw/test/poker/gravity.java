package tw.test.poker;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import tw.test.apis.point;

public class gravity extends JFrame {

	public JPanel bg;
	
	public gravity() {
		
		bg = new background();
		add(bg,BorderLayout.CENTER);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new gravity();
	}
}

class background extends JPanel {
	
	private LinkedList<line> lines , lines2;
	
	public background() {
		
		lines = new LinkedList<>();
		lines2 = new LinkedList<>();
		
		my_mouse myListener = new my_mouse();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class my_mouse extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			line line = new line(Color.red,3);
			point p1 = new point(e.getX(),e.getY());
			line.add_point(p1);
			lines.add(line);
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			point p1 = new point(e.getX(),e.getY());
			lines.getLast().add_point(p1);
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics point) {
		super.paintComponent(point);
		Graphics2D g2d = (Graphics2D) point;
		
		for (line line : lines) {
			g2d.setStroke(new BasicStroke(3));
			for(int i=1;i<line.get_size();i++) {
				point p0 = line.get_point(i-1);
				point p1 = line.get_point(i);
				g2d.drawLine(p0.getX(),p0.getY(),p1.getX(),p1.getY());
			}
		}
	}
}

class line {
	
	private LinkedList<point> line;
	private LinkedList<point> line2;
	
	public line(Color color, int width) {
		line = new LinkedList<>();
		line2 = new LinkedList<>();
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