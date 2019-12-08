package experiment2;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Model extends JFrame {
	public static void main(String[] args) {
		Model md=new Model();
	}
	public Model(){
		init();
        this.setSize(800,600);
        this.setVisible(true);
	}
	public void init(){
	   StringBuffer sbu=new StringBuffer();
	   setTitle("学生选课系统");
	   JTextArea textArea = new JTextArea();
	   MyActionListener myActionListener = new MyActionListener(textArea);
	   JButton jreset = new JButton("重置");
	   jreset.setBounds(10, 10, 150, 18);
	   JButton jview= new JButton("查看具体选课信息");
	   jview.setBounds(10, 10, 150, 18);
	   jview.addActionListener(myActionListener);
	   JButton jdelete = new JButton("退课");
	   jdelete.setBounds(10, 10, 150, 18);
	   ActionListener myActionListener2=new MyActionListener2(textArea);
	   jdelete.addActionListener(myActionListener2);
	   JPanel  panel = new JPanel();
	   //panel.setBounds(10, 10, 200, 20);
      // String[] str = { "可选课列表:","高数", "Java", "英语","网络" };
       //JComboBox j5 = new JComboBox(str);
       final JTextField textField = new JTextField();
       JButton confirm= new JButton("确定");
       //JList list = new JList(str);
       
       textArea.setBackground(Color.lightGray);
       
      
       GridBagLayout layout = new GridBagLayout();
       this.setLayout(layout);
       this.add(jreset);
       this.add(jview);
       this.add(jdelete);
       this.add(panel);
       //this.add(j5);
       this.add(textField);
       this.add(confirm);
      // this.add(list);
       this.add(textArea);
       GridBagConstraints s= new GridBagConstraints();
       s.fill = GridBagConstraints.BOTH;

       s.gridwidth=0;
       s.weightx = 0;
       s.weighty=0;
       layout.setConstraints(panel, s);
//       s.gridwidth=2;
//       s.weightx = 0;
//       s.weighty=0;
//       layout.setConstraints(j5, s);
       s.gridwidth=4;
       s.weightx = 1;
       s.weighty=0;
       layout.setConstraints(textField, s);
       s.gridwidth=0;
       s.weightx = 0;
       s.weighty=0;
       layout.setConstraints(confirm, s);
//       s.gridwidth=2;
//       s.weightx = 0;
//       s.weighty=1;
//       layout.setConstraints(list, s);
       s.gridwidth=5;
       s.weightx = 0;
       s.weighty=1;
       layout.setConstraints(textArea, s);
       //Container cp=getContentPane();
       confirm.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "未选择任何课程!");
					textArea.setText(" ");
					return;
				}
				else {
					sbu.append(textField.getText());
					textArea.setText(sbu.toString());
					JOptionPane.showMessageDialog(null,sbu.toString()+ "选课成功");
					
				}
				
				}
       });
       jreset.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent arg0) {
    		   textField.setText("");
   }
       });
       jview.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().trim().length()==0){
					JOptionPane.showMessageDialog(null, "未选择任何课程!");
					textArea.setText(" ");
					return;
				}
				else {
					Test test=new Test();
					Course course=new Course();
					StringBuffer str=new StringBuffer();
					str.append("课程编号："+course.getCid()+"课程名称:"+course.getCName()+"上课地址:"+course.getCAddress()+"上课时间："+course.getDate()+"学分："+course.getCredit()+"任课教师："+course.getTeacher());
					textArea.setText(str.toString());
				}
				
				}
       });
	}
	class MyActionListener implements ActionListener{
   	 	
 		 private JTextArea textArea;
		 
 		 public MyActionListener(JTextArea textArea) {
 			super();
 			this.textArea = textArea;
 		}
 		public void actionPerformed(ActionEvent e) {
 			JButton confirm= new JButton("确定");
 			//textArea.setText(course+" ");
// 			if(confirm != null){
// 			//textArea.setText(" " +student+ " \n"+teacher+" \n"+course+" ");}
// 			else{
// 				textArea.setText("请先提交课程信息");
// 			}
//}
 	       }
 	}
 	class MyActionListener2 implements ActionListener{
 		
 		private JTextArea textArea;
 		//private JTextField textField;
 		public MyActionListener2(JTextArea textArea) {
 			super();
 			this.textArea = textArea;
 			//this.textField=textField;
 		}
 		public void actionPerformed(ActionEvent e) {
 			//textField.setText(" ");
 			textArea.setText("高数已退课");
 			
 		
 		} 
 
			
		}}
	
       
	

	
  
	

