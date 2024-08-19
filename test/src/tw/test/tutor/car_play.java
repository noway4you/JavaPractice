package tw.test.tutor;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class car_play extends JFrame {
	
	private JButton b1,b2,b3;
	
	public car_play() {
		
		b1 = new JButton("first");
		b2 = new JButton("second");
		b3 = new JButton("third");
		
		setLayout(new FlowLayout(10,10,100));
		add(b1);add(b2);add(b3);
		
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new car_play();
	}

}
