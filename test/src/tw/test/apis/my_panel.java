package tw.test.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class my_panel extends JPanel {
	private LinkedList<line> lines, recycle;
	private Color nowColor;
	
	public my_panel() {
		setBackground(Color.YELLOW);
		
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		
		nowColor = Color.BLACK;
		MyListener myListener = new MyListener();
		
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			
			line line = new line(nowColor, 4);
			point point = new point(e.getX(), e.getY());
			line.add_point(point);
			
			lines.add(line);
			
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			point point = new point(e.getX(), e.getY());
			lines.getLast().add_point(point);;
			
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		

		for (line line  : lines) {
			
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			
			for (int i = 1; i< line.get_size(); i++) {
				point p0 = line.get_point(i-1);
				point p1 = line.get_point(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
		}
		
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0 ) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}

	public void redo() {
		if (recycle.size() > 0 ) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}
	
	public Color getColor() {
		return nowColor;
	}
	
	public void setColor(Color color) {
		nowColor = color;
	}
	
	public void saveLines(File saveFile) throws Exception {
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(saveFile));
		oout.writeObject(lines);
		oout.flush();
		oout.close();
	}
	
	public void loadLines(File loadFile) throws Exception {
		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream(loadFile))){
			Object obj = oin.readObject();
			lines = (LinkedList<line>)obj;
			repaint();
		}
		
	}
	
	public void saveImage() throws IOException {
		BufferedImage img = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		paint(g);
		
		ImageIO.write(img,"jpg",new File("dir1/sign.jpg"));
	}
	
}