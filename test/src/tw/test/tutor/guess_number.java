package tw.test.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class guess_number extends JFrame implements ActionListener{
	
	private JTextField input;
	private JTextArea log;
	private JButton guess;
	private StringBuffer ans;
	private int counter = 0;
	
	public guess_number() {
		super("Guess Number");
		
		input = new JTextField();
		log = new JTextArea();
		guess = new JButton("guess");
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess,BorderLayout.EAST);
		top.add(input,BorderLayout.CENTER);
		
		add(top,BorderLayout.NORTH);
		add(log,BorderLayout.CENTER);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		input.setFont(new Font(null,Font.BOLD | Font.ITALIC,20));
		
		init();
		event();
	}
	
	private void init() {
		ans = answer(5);
	}
	
	private void event() {
		guess.addActionListener(this);
	}
	
	private static StringBuffer answer(int n) {
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			int r = (int)(Math.random()*10);
			num[i] = r;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) sb.append(num[i]);
	
		return sb;
	}

	public static void main(String[] args) {
		guess_number game = new guess_number();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(ans);
		String g = input.getText();
		log.append(check(g,ans));
		input.setText("");
		
		if(check(g,ans).equals("Correct!\n---------\n")) {
			JOptionPane.showMessageDialog(null,"You Win!");
			int a = JOptionPane.showConfirmDialog(null, "Try Again?");
			if(a==0) {
				setVisible(false);
				new guess_number();
			}else setVisible(false);
		}else {
			counter++;
			if(counter >= 3) {
				JOptionPane.showMessageDialog(null,"You Lose!");
				int a = JOptionPane.showConfirmDialog(null, "Try Again?");
				if(a==0) {
					setVisible(false);
					new guess_number();
			}else setVisible(false);
		}
		}
	}
	
	private String check(String g,StringBuffer ans2) {
		int a = 0 , b = 0;
		if(g.length() > ans2.length()) return "Too long\n---------\n";
		for(int i=0;i<g.length();i++) {
			if(g.charAt(i)==ans2.charAt(i)) {
				a++;
				continue;
			}
			for(int j=0;j<ans2.length();j++) {
				if(g.charAt(i)==ans2.charAt(j) && i!=j) {
					b++;
					break;
				}
			}
		}
		return a==ans2.length()?"Correct!\n---------\n":"right place = "+a+"\nwrong place = "+b+"\n---------\n";
	}
}
