package tw.test.snipping_tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame{
	
	private JButton snip ,renew;
	private JFrame frame2,frame3;
	private JPanel jp;
	private int x0,y0,x1,y1;
	private Rectangle rect;
	private BufferedImage buffer;
	private Timer timer;

	public Main() {
		snip = new JButton("snip");
		setLayout(new BorderLayout());
		add(snip,BorderLayout.CENTER);
		
		setSize(200,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	public void initEvent() {
		snip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				frame2 = new JFrame();
				frame2.setExtendedState(MAXIMIZED_BOTH);
				frame2.setUndecorated(true);
				frame2.setOpacity(0.2f);
				frame2.setVisible(true);
				jp = new JPanel();
				frame2.add(jp);
				my_mouse mp = new my_mouse();
				jp.addMouseListener(mp);
				jp.addMouseMotionListener(mp);
			}
		});
	}
	
	private class my_mouse extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			x0 = e.getXOnScreen();
			y0 = e.getYOnScreen();
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			x1 = e.getXOnScreen();
			y1 = e.getYOnScreen();
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			frame2.setVisible(false);
			File file = new File("dir2/capture.jpg");
			rect = new Rectangle(x0,y0,Math.abs(x0-x1),Math.abs(y0-y1));
			try {
				buffer = new Robot().createScreenCapture(rect);
			} catch (Exception e1) {
				System.out.println("error => " + e1);
			}
			try {
				ImageIO.write(buffer,"jpg",file);
			} catch (Exception e1) {
				System.out.println("error => " + e1);
			}
			frame2.dispose();
			frame3();
		}
	} 
	
	public void frame3() {
		frame3 = new JFrame();
		frame3.setLayout(new BorderLayout());
		renew = new JButton("renew");
		jp.add(renew);
		frame3.add(jp,BorderLayout.NORTH);
		ImageIcon img = new ImageIcon("dir2/capture.jpg");
		JLabel label = new JLabel(img);
		frame3.add(label);
		frame3.setSize(img.getIconWidth()+100,img.getIconHeight()+100);
		frame3.setVisible(true);
		
		initEvent2();
	}
	
	public void initEvent2() {
		renew.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				frame3.setVisible(false);
				frame3.dispose();
				File file = new File("dir2/capture.jpg");
				new Main();
			}
		});
	}
	
	public static void main(String[] args) {
		new Main();
	}
}

