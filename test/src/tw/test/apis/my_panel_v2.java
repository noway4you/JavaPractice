package tw.test.apis;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class my_panel_v2 extends JPanel implements ActionListener{
	
	private LinkedList<line> lines , lines2;
	public JButton undo , redo , clear , color , width , save , open;
	public JPanel top;
	public Color nowcolor = Color.black;
	public int nowWidth = 2;
	
	public my_panel_v2(){
		
		undo = new JButton("undo");
		redo = new JButton("redo");
		clear = new JButton("clear");
		color = new JButton("color");
		width = new JButton("width");
		save = new JButton("save");
		open = new JButton("open");
		top = new JPanel(new FlowLayout());
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(color);
		top.add(width);
		top.add(save);
		top.add(open);
		lines = new LinkedList<>();
		lines2 = new LinkedList<>();
		my_mouse myListener = new my_mouse();
		
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		undo.addActionListener(this);
		redo.addActionListener(this);
		clear.addActionListener(this);
		color.addActionListener(this);
		width.addActionListener(this);
		save.addActionListener(this);
		open.addActionListener(this);
	}
	
	private class my_mouse extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			lines2.clear();
			line line = new line(nowcolor,nowWidth);
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
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			for(int i=1;i<line.get_size();i++) {
				point p0 = line.get_point(i-1);
				point p1 = line.get_point(i);
				g2d.drawLine(p0.getX(),p0.getY(),p1.getX(),p1.getY());
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == undo) {
			if(lines.size() > 0) lines2.add(lines.removeLast());
		}
		else if(e.getSource() == redo){
			if(lines2.size() > 0) lines.add(lines2.removeLast());
		}else if(e.getSource() == clear){
			if(lines.size()!=0) {
				lines.clear();
				lines2.clear();
			}
		}else if(e.getSource()==color) {
			JColorChooser newcolor = new JColorChooser();
			nowcolor = newcolor.showDialog(null,"color",nowcolor);
		}else if(e.getSource()==width) {
			JOptionPane option = new JOptionPane();
			nowWidth = Integer.parseInt(option.showInputDialog("enter the width :"));
		}else if(e.getSource()==save) {
			try {
				JFileChooser choose = new JFileChooser();
				File save_file = null;
				if(choose.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
					save_file = choose.getSelectedFile();
				}
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(save_file));
				oout.writeObject(lines);
				oout.flush();
				oout.close();
			} catch (Exception e1) {
				System.out.println("error => " + e1);
			}
		}else if(e.getSource()==open) {
			try {
				JFileChooser choose = new JFileChooser();
				File load_file = null;
				if(choose.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
					load_file = choose.getSelectedFile();
				}
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream(load_file));
				Object obj = oin.readObject();
				lines = (LinkedList<line>)obj;
				oin.close();
			} catch (Exception e1) {
				System.out.println("error => " + e1);
			}
		}
		repaint();
	}
	
	
}