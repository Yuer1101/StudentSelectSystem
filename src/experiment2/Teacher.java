package experiment2;

public class Teacher extends Person{

	public Teacher(int number, String name, String sex,Course course) {
		super(number, name, sex);
		this.course=course;
		
	}

	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}