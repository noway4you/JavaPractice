package tw.test.practice;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.test.apis.my_panel;
import tw.test.apis.my_panel_v2;

public class signature_app_v3 extends JFrame{

	private my_panel_v3 myPanel;
	
	public signature_app_v3(){
		super("signature");
		
		myPanel = new my_panel_v3();
		setLayout(new BorderLayout());
		add(myPanel.top,BorderLayout.NORTH);
		add(myPanel,BorderLayout.CENTER);
		
		setVisible(true);
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new signature_app_v3();
	}

}