package tw.test.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JComponent;

public class MyClock extends JComponent{
	
	private Timer timer;
	private double s,m,h;
	private long mili;
	private Date date;
	
	public MyClock() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new MyTask(),0,16);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.red);
		g2d.drawOval(3,6,500,500);
		g2d.setColor(Color.black);
		g2d.fillOval(3,6,500,500);
		g2d.setColor(Color.WHITE);
		g2d.drawOval(248,251,10,10);
		g2d.drawLine(253,256,(int)(253+200*Math.sin(s)),(int)(256-200*Math.cos(s)));
		g2d.drawLine(253,256,(int)(253+150*Math.sin(m)),(int)(256-150*Math.cos(m)));
		g2d.drawLine(253,256,(int)(253+80*Math.sin(h)),(int)(256-80*Math.cos(h)));
		g2d.setFont(new Font("TimesRoman",Font.PLAIN,40)); 
		for(int i=0;i<12;i++) {
			if(i<9) g2d.drawString(Integer.toString(i+1),(float)(240+230*Math.sin((Math.PI/6)*(i+1))),(float)(270-220*Math.cos((Math.PI/6)*(i+1))));
			else g2d.drawString(Integer.toString(i+1),(float)(230+230*Math.sin((Math.PI/6)*(i+1))),(float)(270-220*Math.cos((Math.PI/6)*(i+1))));
		}
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.gray);
		g2d.fillRect(173,128,160,40);
		g2d.fillRect(151,320,204,40);
		g2d.setColor(Color.WHITE);
		g2d.drawString(date.getHours()+":"+date.getMinutes()+":"+date.getSeconds(),175,163);
		g2d.drawString((date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate(),157,355);
	}
	
	private class MyTask extends TimerTask{
		@Override
		public void run() {
			
			date = new Date();
			mili = System.currentTimeMillis();
			s = (Math.PI/30000)*mili;
			m = s/60;
			h = (Math.PI/6)*date.getHours() + (Math.PI*date.getMinutes()/360);
			repaint();
		}
	}
}
