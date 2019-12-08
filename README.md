**计G191 2019322027  王笑悦**
## 综合性实验  学生选课系统设计    

### **一、实验目的**

- 分析学生选课系统
- 使用GUI窗体及其组件设计窗体界面
- 完成学生选课过程业务逻辑编程
- 基于文件保存并读取数据
- 处理异常

### **二、实验要求**
#### 1.系统角色分析及类设计
学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。定义每种角色人员的属性，及其操作方法。 

#### 2.要求    

1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。

2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。

3、针对操作过程中可能会出现的各种异常，做异常处理

4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。

- ####  回顾：在有关学生选课系统实验中，前两次已经完成了学生类、教师类、课程类以及人员类的设计，并有相应的测试类完成了测试，后又使用GUI创建了登录界面与管理员添加课程、选课退课界面，完成了部分功能。本次实验在上述基础上添加了注册界面，并利用所学字符串、文件流、异常处理知识对之前功能做了相应完善。以下是本次实验实验过程：
    
### **三、实验过程**
   
    1.创建Register类，作为用户注册界面，并利用GUI组件设置用户名文本框、密码框以及确认密码输入框，提交按钮。对于用于输入的两次密码利用数组获取并判断是否相等，若相等，把注册信息写入到文件中，如果文件不存在则创建文件，此处进行IO异常处理；若两次密码不相等，弹出错误信息，用户重新输入。
    
    2.在Login类中添加读文件的方法，对确定登录按钮实现事件处理，检索文件中信息，若是用户注册过的信息，则可以登录成功。此时需要选择人员身份，选择学生，登录成功后跳转选课界面；选择管理员，登录成功后跳转选课信息添加课程界面。
    
    3.在选课信息界面Information中，管理员可以添加课程有关信息，并提交，此时对提交按钮的事件处理是把管理员输入的信息写入到文件中保存起来。提交成功跳转至学生选课界面。
    
    4.学生选课界面Model，在文本框输入想要选择的课程名称，此时对提交按钮的事件处理是如果名称不为空，则利用StringBuffer的append方法在文本框下方的文本域中显示输入的课程信息，并弹出提示框xx（课程名称）选课成功。对于上方“查看选课信息”的事件处理，若输入框没有课程信息则显示“未选择课程”，若有已选课程，则调用course类显示相应的课程信息在文本域中，学生可以查看到具体选课信息。右上角“重置”可以清空文本框与文本域。点击退课，即可退课成功。
  
    
### **四、类的介绍**

+ Student：学生类

+ Teacher：教师类

+ Course：课程类

+ Person：人员类，学生与教师的父类

+ Register：注册界面

+ Login：登录界面

+ Information：管理员添加课程界面

+ Model：学生选课界面

### **五、核心代码**

1.Register类中，利用数组判断两次密码是否相等 

        char[] password1 = passwordField1.getPassword();// 获得密码框1中的密码
		char[] password2 = passwordField2.getPassword();// 获得密码框2中的密码
		boolean equals = Arrays.equals(password1, password2);// 判断两个密码框中密码是否相同
        
 2.如果两次密码相同，则把用户在注册界面输入的信息写入到文件中，并跳转至登录界面
 
        String str2=textField.getText()+","+passwordField1; //用户名及密码信息放到字符串中
			File f=new File("info.txt"); //文件路径
			try { if(!f.exists()) { //如果文件不存在则创建文件
				f.createNewFile(); } 
			FileWriter hu=new FileWriter(f,true);
			BufferedWriter buff=new BufferedWriter(hu); 
			buff.write(str2);//str2字符输入到缓冲区
			buff.newLine(); 
			buff.flush(); //刷新
			buff.close(); //关闭
			JOptionPane.showMessageDialog(null, "提交成功"); 
			Login login=new Login();//跳转至登录界面
            
3.Login类中创建readFile方法，读取文件中信息，并做异常处理

        try {
			   fileReader = new FileReader("info.txt");//读取文件，文件路径
			   int read = fileReader.read();
			   subname=name.getText();
			   subpwd=password.getText();
			   
			   while(read!=-1){//while循环，遍历文件信息读取文件内容
			    System.out.print((char)read);
			    read = fileReader.read();
			    }
			   if(fileReader.toString().contains(subname)&&fileReader.toString().contains(subpwd)){//判断输入的文件名及密码是否在文件中
			    
			    Model model=new Model();//匹配成功，跳转至学生选课界面。若为管理员，选课成功跳转至选课信息界面，此处方法相同，不列出
			   }
			   
			   else {
			    JOptionPane.showMessageDialog(null, "用户名或密码错误");
			   }
			   
			   
			   
			  }catch (IOException e) {
			   // TODO Auto-generated catch block
			   System.out.println(e);//若有异常，捕获异常信息
			  }
 
 4.在Information类对管理员在界面输入的信息写到文件中，利用字符文件流及缓冲流FileWriter和BufferWriter方法，写入文件方法与Register类写入文件相同，提交成功跳转至Model学生选课界面，并做异常处理
 
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

5.在Model学生选课界面，利用StringBuffer的append方法把文本框textField输入的课程信息加入到文本域中，并在弹出框中显示

        sbu.append(textField.getText());
					textArea.setText(sbu.toString());
					JOptionPane.showMessageDialog(null,sbu.toString()+ "选课成功");
6. 对于查询选课信息的事件处理

        public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().trim().length()==0){//如果文本框为空
					JOptionPane.showMessageDialog(null, "未选择任何课程!");
					textArea.setText(" ");
					return;
				}
				else {
					Test test=new Test();
					Course course=new Course();//调用course类
					StringBuffer str=new StringBuffer();//实例化StringBuffer方法
					str.append("课程编号："+course.getCid()+"课程名称:"+course.getCName()+"上课地址:"+course.getCAddress()+"上课时间："+course.getDate()+"学分："+course.getCredit()+"任课教师："+course.getTeacher());//调用append添加到字符串
					textArea.setText(str.toString());//在文本域输出
				}
                
### **六、系统运行截图**

1.注册界面

![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E5%AD%A6%E7%94%9F%E6%B3%A8%E5%86%8C.PNG)

2.登录界面

![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E6%9F%A5%E7%9C%8B.PNG)

3.管理员添加课程界面

![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E7%99%BB%E5%BD%95.PNG)

4.学生选课界面输入课程名称

![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E9%80%80%E8%AF%BE.PNG)

5.查询选课信息

![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E9%80%89%E8%AF%BE.PNG)

6.退课


![](https://github.com/Yuer1101/StudentSelectSystem/blob/master/img/%E9%80%89%E8%AF%BE%E5%88%97%E8%A1%A8.PNG)

### **七、实验心得**
通过本次实验比较完整的完成了学生管理系统的设计，通过一个星期对课本知识完整的复习，我更加理解了方法的使用，对此次实验的一些功能也做了完善。除了基本的界面设计，对于事件处理的方法书写也比较熟悉，通过课本及网上资料的帮助，也完成了对文件的读取和写入的实际性操作，文件的保存相当于一个小型数据库的存在，与此同时我对于异常处理方法的书写与应用也游刃有余，每实现一个小的功能都会有收获，也提升了我的兴趣。本次实验不足的地方在于管理员添加课程提交的时候功能不太完善，退课操作和查看课程信息调用数据实现的不是很好，在跳转另外一个界面的时候原界面不会自动关闭，今后我会多加练习，不断地是自己进步。
