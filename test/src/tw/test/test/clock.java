package tw.test.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.test.apis.MyClock;

public class clock extends JFrame{

	public clock() {
		
		MyClock c = new MyClock();
		
		setLayout(new BorderLayout());
		add(c,BorderLayout.CENTER);
		
		setSize(530,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new clock();
	}

}
