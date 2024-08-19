package tw.test.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class thread_practice extends JFrame{
	private JButton start;
	private JLabel[] lanes;
	private car[] cars;
	private boolean check = true;
	
	public thread_practice() {
		
		super("Racing");
		
		start = new JButton("Start");
		add(start);
		lanes = new JLabel[8];
		setLayout(new GridLayout(9,1));
		for(int i=0;i<lanes.length;i++) {
			lanes[i] = new JLabel((i+1) + " : ");
			add(lanes[i]);
		}
		
		setSize(1024,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initGame();
	}
	
	private void initGame() {
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check) {
					start();
					check = false;
				}
			}
		});
	}
	
	private void start() {
		for(int i=0;i<lanes.length;i++) {
			lanes[i].setText((i+1) + " : ");
		}
		cars = new car[8];
		for(int i=0;i<cars.length;i++) {
			cars[i] = new car(i);
		}
		for(int i=0;i<cars.length;i++) {
			cars[i].start();
		}
	}
	
	private class car extends Thread{
		private int lane;
		private StringBuffer buffer;
		
		car(int lane){
			this.lane = lane;
			buffer = new StringBuffer((lane+1) + " : ");
		}
		
		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				buffer.append(">");
				
				if(i==99) {
					buffer.append("winner");
				}
				
				lanes[lane].setText(buffer.toString());
				
				if(i==99) {
					check = true;
					stopGame();
				}
				
				try {
					sleep(10 + (int)(Math.random()*100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	
	void stopGame() {
		for(int i=0;i<cars.length;i++) {
			cars[i].interrupt();
		}
	}
	
	public static void main(String[] args) {
		new thread_practice();
	}

}
