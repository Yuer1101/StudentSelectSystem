package experiment2;

public class Person {

	private Integer number;
	private String name;
	private String sex;
	public Person(int number, String name, String sex) {
		this.number=number;
		this.name=name;
		this.sex=sex;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	

	@Override
	public String toString() {
		return "人员编号:" + number + ", 姓名:" + name + ",性别:" + sex;
	}
	
}