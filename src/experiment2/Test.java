package experiment2;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
			Course course1 = new Course(1,"高数","教102","周一",5);
			
			Teacher teacher1 = new Teacher(1, "任老师", "男", course1);
			
			Course course2 = new Course(1,"英语","教408","周一",2);
			
			Teacher teacher2 = new Teacher(2, "刘老师", "女", course2);
			
			Student student1 = new Student(1, "张三", "男", course1,teacher1);
			
			Student student2 = new Student(2, "李四", "男", course2,teacher2);
			
			course1.setTeacher(teacher1);
			course1.getStudent().add(student1);
			course1.getStudent().add(student2);
			student1.setCourse(course1);
			student2.setCourse(course1);
			teacher1.setCourse(course1);
			course1.getStudent().remove(student1);
			System.out.println(course1);
			
		}
	}


