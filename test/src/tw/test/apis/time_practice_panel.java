package tw.test.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class time_practice_panel extends JPanel{
	
	public BufferedImage img;
	public int ballX,ballY,displacementX,displacementY;
	private Timer timer;
	
	public time_practice_panel() {
		ballX = 4;
		ballY = 4;
		displacementX = 4;
		displacementY = 4;
		setBackground(Color.black);
		try {
			img = ImageIO.read(new File("dir1/ball0.png"));
			
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
		addMouseListener(new MyListener());
		timer = new Timer();
		timer.schedule(new MyTask(),1000,16);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,ballX,ballY,null);
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			ballX = e.getX()-(int)(img.getWidth()/2.0);
			ballY = e.getY()-(int)(img.getHeight()/2.0);
			repaint();
		}
	}
	
	private class MyTask extends TimerTask{
		@Override
		public void run() {
			if((ballX+(int)(img.getWidth()/2.0))>=getWidth()||((ballX-(int)(img.getWidth()/2.0))<0)){
				displacementX *= -1;
			}
			if((ballY + (int)(img.getWidth()/2.0))>=getHeight()||((ballY -(int)(img.getHeight()/2.0))<0)){
				displacementY *= -1;
			}
			ballX += displacementX;
			ballY += displacementY;
			repaint();
		}
	}
}
