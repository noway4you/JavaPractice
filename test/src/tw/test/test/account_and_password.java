package tw.test.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tw.test.bcrypt.BCrypt;

public class account_and_password{
	
	public static void main(String[] args) {
		new LoginGUI();
	}
}

class LoginGUI extends JFrame {
	 JPanel LoginPanel;
	 LoginGUI(){
	  LoginPanel = new JPanel();
	  
	  JLabel usernameLabel = new JLabel("Enter account：");
	  JTextField usernameText = new JTextField();
	  
	  JLabel PasswordLabel = new JLabel("Enter password：");
	  JPasswordField PasswordText = new JPasswordField();
	  
	  JButton LoginButton = new JButton("Login");
	  JButton RegisterButton = new JButton("Sign in");
	  
	  LoginButton.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  String username = usernameText.getText();
			  String password = new String(PasswordText.getPassword());
			  
			  Properties prop = new Properties();
			  prop.put("user","root");
			  prop.put("password","root");
			  String url = "jdbc:mysql://127.0.0.1:3306/brad";
				
			  try {
					Connection conn = DriverManager.getConnection(url,prop);
					String sql = "select account,password,name from member where account = '" + username + "'";
					Statement state = conn.createStatement();
					ResultSet result = state.executeQuery(sql);
					
					while(result.next()) {
						if(BCrypt.checkpw(password,result.getString("password"))) {
							JOptionPane.showMessageDialog(LoginGUI.this,"user name = " + result.getString("name"),"success",JOptionPane.WARNING_MESSAGE);
							break;
						}else {
							JOptionPane.showMessageDialog(null,"wrong password");
							break;
						}
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"no account");
					System.out.println(e1);
				}
		  }
	  });

	  RegisterButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    new RegisterGUI();
	    setVisible(false);
	    dispose();
	   }
	  });

	  LoginPanel.setLayout(new GridLayout(3, 2, 20, 30));
	  LoginPanel.add(usernameLabel); LoginPanel.add(usernameText);
	  LoginPanel.add(PasswordLabel); LoginPanel.add(PasswordText);
	  LoginPanel.add(LoginButton); LoginPanel.add(RegisterButton);
	  EmptyBorder emptyBorder = new EmptyBorder(30, 60, 80, 60);
	  EmptyBorder emptyBorder1 = new EmptyBorder(50, 60, 60, 60);
	  LoginPanel.setBorder(emptyBorder1);
	  
	  this.pack();
	  this.setTitle("Login");
	  this.setSize(400, 300);
	  this.setLocationRelativeTo(null);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLayout(new BorderLayout());
	  this.add(LoginPanel, BorderLayout.CENTER);  
	 }
}

class RegisterGUI extends JFrame {
	 JPanel RegisterPanel, Button_RPanel;
	 RegisterGUI(){

	  RegisterPanel = new JPanel();
	  Button_RPanel = new JPanel();

	  JLabel usernameLabel_R = new JLabel("Enter account：");
	  JTextField usernameText_R = new JTextField();
	  
	  JLabel PasswordLabel_R = new JLabel("Enter password：");
	  JPasswordField PasswordText_R = new JPasswordField();
	  
	  JLabel nameLabel_R = new JLabel("Enter name：");
	  JTextField nameText_R = new JTextField();
	  
	  JButton RegisterButton_R = new JButton("Sign in");
	  RegisterButton_R.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    String username = usernameText_R.getText();
	    String password = new String(PasswordText_R.getPassword());
	    String new_password = BCrypt.hashpw(password,BCrypt.gensalt());
	    String name = nameText_R.getText();
	    
	    Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		String url = "jdbc:mysql://127.0.0.1:3306/brad";
		
		try {
			Connection conn = DriverManager.getConnection(url,prop);
			String sql = "insert into member(account,password,name) values (?,?,?)";
			PreparedStatement state = conn.prepareStatement(sql);
			state.setString(1,username);
			state.setString(2,new_password);
			state.setString(3,name);
			state.executeUpdate();
			JOptionPane.showMessageDialog(null,"success");
			setVisible(false);
			dispose();
			new LoginGUI();
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null,"failed");
		}
	   }
	  });
	  
	  RegisterPanel.setLayout(new GridLayout(3, 2, 20, 30));
	  RegisterPanel.add(usernameLabel_R); RegisterPanel.add(usernameText_R);
	  RegisterPanel.add(PasswordLabel_R); RegisterPanel.add(PasswordText_R);
	  RegisterPanel.add(nameLabel_R); RegisterPanel.add(nameText_R);
	  Button_RPanel.setLayout(new GridLayout(1, 1, 20, 30));
	  Button_RPanel.add(RegisterButton_R);
	  EmptyBorder emptyBorder = new EmptyBorder(20, 30, 30, 30);
	  RegisterPanel.setBorder(emptyBorder);
	  EmptyBorder emptyBorder_B = new EmptyBorder(0, 120, 40, 120);
	  Button_RPanel.setBorder(emptyBorder_B);
	  
	  this.setTitle("Sign in");
	  this.setSize(400, 300);
	  this.setLocationRelativeTo(null);
	  this.setVisible(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLayout(new BorderLayout());
	  this.add(RegisterPanel, BorderLayout.CENTER);
	  this.add(Button_RPanel, BorderLayout.SOUTH);
	 }
}

