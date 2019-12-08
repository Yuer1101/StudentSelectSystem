package experiment2;

public class Student extends Person{
		private Course course;
		private Teacher teacher;
		public Student(int number, String name, String sex,Course course,Teacher teacher) {
		super(number, name, sex);
		this.course=course;
		this.teacher=teacher;
	}
		public Teacher getTeacher() {
			return teacher;
		}
		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
		public Course getCourse() {
			return course;
		}

		public void setCourse(Course course) {
			this.course = course;
		}
		
		
		
	}


