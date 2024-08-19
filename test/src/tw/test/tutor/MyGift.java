package tw.test.tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.test.apis.GiftTable;

public class MyGift extends JFrame{
	
	private GiftTable giftTable;
	private JButton del;
	
	public MyGift() {
		super("MyGift");
		
		setLayout(new BorderLayout());
		del = new JButton("del");
		JPanel top = new JPanel();
		top.add(del);
		add(top,BorderLayout.NORTH);
		
		giftTable = new GiftTable();
		JScrollPane sp = new JScrollPane(giftTable);
		add(sp,BorderLayout.CENTER);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				giftTable.delRow();
			}
		});
	}

	public static void main(String[] args) {
		new MyGift();
	}
}
