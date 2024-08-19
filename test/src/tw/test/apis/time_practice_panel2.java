package tw.test.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;

import tw.test.tutor.linkedlist_practice;

public class time_practice_panel2 extends JPanel{
	
	private BufferedImage[] buffers;
	private int ballW,ballH,viewW,viewH;
	private Timer timer;
	private LinkedList<MyTask> balls;
	
	public time_practice_panel2() {
		setBackground(Color.black);
		try {
			buffers = new BufferedImage[]{ImageIO.read(new File("dir1/ball0.png")),
					ImageIO.read(new File("dir1/ball1.png")),
					ImageIO.read(new File("dir1/ball2.png")),
					ImageIO.read(new File("dir1/ball3.png"))};
			ballW = buffers[0].getWidth();
			ballH = buffers[0].getHeight();
		}catch(Exception e) {
			System.out.println("error => " + e);
		}
		balls = new LinkedList<>();
		addMouseListener(new MyListener());
		timer = new Timer();
		timer.scheduleAtFixedRate(new RefreshTask(),0,16);
	}
	
	
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			int event_x = e.getX() - (int)(ballW/2.0);
			int event_y = e.getY() - (int)(ballH/2.0);
			
			MyTask ball = new MyTask(event_x,event_y);
			balls.add(ball);
			timer.scheduleAtFixedRate(ball,100,16);
		}
	}
	
	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class MyTask extends TimerTask{
		private int x,y,dx,dy;
		private int img;
		
		public MyTask(int x,int y){
			this.x = x;
			this.y = y;
			dx = (int)(Math.random()*9) - 4;
			dy = (int)(Math.random()*9) - 4;
			img = (int)(Math.random()*4);
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getImg() {
			return img;
		}

		@Override
		public void run() {
			if (x <= 0 || x + ballW > viewW) {
				dx *= -1;
				x = x <= 0 ? 1 : viewW - ballW;
			}else {
				x += dx;
			}
			if (y <= 0 || y + ballH > viewH) {
				dy *= -1;
				y = y <= 0 ? 1 : viewH - ballH;
			}else {
				y += dy;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth();
		viewH = getHeight();
		
		for(MyTask ball : balls) {
			g.drawImage(buffers[ball.getImg()],ball.getX(),ball.getY(),null);
		}
	}
}
