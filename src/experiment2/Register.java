package experiment2;


import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
 
	public static void main(String[] args) {
		Register frame = new Register();
		frame.setVisible(true);
	}
 
	public Register() {
		setTitle("学生注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 5, 5));
 
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
 
		JLabel label1 = new JLabel("学生基本信息注册");
		panel1.add(label1);
 
		JPanel panel2 = new JPanel();
		panel2.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT));
		contentPane.add(panel2);
 
		JLabel label2 = new JLabel("用  户  名");
		panel2.add(label2);
 
		textField = new JTextField();
		panel2.add(textField);
		textField.setColumns(16);
 
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPane.add(panel3);
 
		JLabel label3 = new JLabel("密        码");
		panel3.add(label3);
 
		passwordField1 = new JPasswordField();
		passwordField1.setColumns(16);
		panel3.add(passwordField1);
 
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		contentPane.add(panel4);
 
		JLabel label4 = new JLabel("确认密码");
		panel4.add(label4);
 
		passwordField2 = new JPasswordField();
		passwordField2.setColumns(16);
		panel4.add(passwordField2);
 
		JPanel panel5 = new JPanel();
		contentPane.add(panel5);
 
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						do_button_actionPerformed(e);
				
			}
		});
		panel5.add(button);
	}
 
	protected void do_button_actionPerformed(ActionEvent e){
		char[] password1 = passwordField1.getPassword();// 获得密码框1中的密码
		char[] password2 = passwordField2.getPassword();// 获得密码框2中的密码
		boolean equals = Arrays.equals(password1, password2);// 判断两个密码框中密码是否相同
		if (equals) {// 如果密码相同则提示注册成功
			String str2=textField.getText()+","+passwordField1; 
			File f=new File("info.txt"); 
			try { if(!f.exists()) { 
				f.createNewFile(); } 
			FileWriter hu=new FileWriter(f,true);
			BufferedWriter buff=new BufferedWriter(hu); 
			buff.write(str2);
			buff.newLine(); 
			buff.flush(); 
			buff.close(); 
			JOptionPane.showMessageDialog(null, "提交成功"); 
			Login login=new Login();
			}
			catch(Exception e1) { e1.printStackTrace(); }
			
		
		} else {// 如果密码不同则提示密码不同
			JOptionPane.showMessageDialog(this, "两次密码不同！", null,
					JOptionPane.WARNING_MESSAGE);
		}
	}
}

