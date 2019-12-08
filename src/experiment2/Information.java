package experiment2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Information extends JFrame implements ActionListener {
	public Information() {
		super("选课信息列表");
		DefaultTableModel model=new DefaultTableModel();
		Course course=new Course();
		model.setColumnIdentifiers(new Object[]{"课程编号","课程名称","上课地址","上课时间","学分","教师编号","授课教师","教师性别"});
		model.addRow(new Object[] {course.getCid(),course.getCName(),course.getCAddress(),course.getDate(),course.getCredit(),course.getTeacher()});
		Connection con=null;
		JTable table=new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		JScrollPane scrollPane=new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		JButton button=new JButton("提交");
		GridBagLayout layout = new GridBagLayout();
	    this.setLayout(layout);
		this.add(button);
		GridBagConstraints s= new GridBagConstraints();
		s.gridwidth=0;
	    s.weightx = 0;
	    s.weighty=0;
	    layout.setConstraints(button, s);
		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String str2="课程编号："+course.getCid()+"课程名称:"+course.getCName()+"上课地址:"+course.getCAddress()+"上课时间："+course.getDate()+"学分："+course.getCredit()+"任课教师："+course.getTeacher();
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
					
					Model model=new Model();

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
			}
			}
		});
		
		pack();
		setVisible(true);
		
	


}
	


	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}