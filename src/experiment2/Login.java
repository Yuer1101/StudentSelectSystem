package experiment2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	FileReader fileReader;
	String subname = null;
	String subpwd=null;
	JTextField name;
	JPasswordField password;
	public Login(){
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("登录界面");
		setBounds(300, 200, 300, 150);
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		JLabel jl=new JLabel("用户名：");
		jl.setBounds(10, 10, 200, 18);
		name=new JTextField(10);
		name.setBounds(80, 10, 150, 18);
		JLabel jl2=new JLabel("密码：");
		jl2.setBounds(10, 50, 200, 18);
		password=new JPasswordField(10);
		password.setBounds(80, 50, 150, 18);
		cp.add(jl);
		cp.add(name);
		cp.add(jl2);
		cp.add(password);
		JButton jb=new JButton("确定");
		
		JRadioButton stu=new JRadioButton("学生");
		cp.add(stu);
		
		stu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==stu) {
					jb.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							readFile1();
							}
					});
			}
			}
		});
		
		JRadioButton adm=new JRadioButton("管理员");
		cp.add(adm);
		adm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==adm) {
					jb.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							readFile2();
						}
					});
			}
			}
		});
		ButtonGroup bg=new ButtonGroup();
		bg.add(stu);
		bg.add(adm);
		jb.setBounds(80, 80, 60, 18);
		cp.add(jb);

		final JButton button = new JButton();
		button.setText("重置");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成方法存根
				name.setText("");
				password.setText("");
			}
		});
		button.setBounds(150, 80, 60, 18);
		getContentPane().add(button);
	}
	public void readFile1() {
		try {
			   fileReader = new FileReader("info.txt");
			   int read = fileReader.read();
			   subname=name.getText();
			   subpwd=password.getText();
			   
			   while(read!=-1){
			    System.out.print((char)read);
			    read = fileReader.read();
			    }
			   if(fileReader.toString().contains(subname)&&fileReader.toString().contains(subpwd)){
			    
			    Model model=new Model();
			   }
			   
			   
			   else {
			    JOptionPane.showMessageDialog(null, "用户名或密码错误");
			   }
			   
			   
			   
			  }catch (IOException e) {
			   // TODO Auto-generated catch block
			   System.out.println(e);
			  }
	}
	
	public void readFile2() {
		try {
			   fileReader = new FileReader("info.txt");
			   int read = fileReader.read();
			   subname=name.getText();
			   subpwd=password.getText();
			   
			   while(read!=-1){
			    System.out.print((char)read);
			    read = fileReader.read();
			    }
			   if(fileReader.toString().contains(subname)&&fileReader.toString().contains(subpwd)){
			    
			    Information info=new Information();
			   }
			   
			   
			   else {
			    JOptionPane.showMessageDialog(null, "用户名或密码错误");
			   }
			   
			   
			   
			  }catch (IOException e) {
			   // TODO Auto-generated catch block
			   System.out.println(e);
			  }
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		login.setSize(150, 200);
		login.setVisible(true);

	}

}
