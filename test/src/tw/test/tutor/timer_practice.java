package tw.test.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.test.apis.time_practice_panel;
import tw.test.apis.time_practice_panel2;

public class timer_practice extends JFrame{
	
	private time_practice_panel2 jp;
	private int width,height;
	
	public timer_practice(){
		
		setLayout(new BorderLayout());
		jp = new time_practice_panel2();
		add(jp,BorderLayout.CENTER);
		
		width = 500;
		height = 500;
		setSize(width,height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new timer_practice();
	}
}
