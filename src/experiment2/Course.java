package experiment2;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Course {
	private Integer Cid;
	private String CName;
	private String CAddress;
	private String date;
	private Integer credit;
	private Teacher teacher;
	private List<Student> student=new ArrayList<Student>();
	
	public Course(int Cid,String CName,String CAddress,
			int credit,String date,Teacher teacher){
		super();
		this.Cid=Cid;
		this.CName=CName;
		this.CAddress=CAddress;
		this.credit=credit;
		this.date=date;
		this.setTeacher(teacher);
		student =new ArrayList<Student>();
	}

	public Course(int Cid,String CName,String CAddress,
			String date,int credit){
		super();
		this.Cid=Cid;
		this.CName=CName;
		this.CAddress=CAddress;
		this.credit=credit;
		this.date=date;
		student =new ArrayList<Student>();
	}
	public Course(){
		super();
		this.Cid=Cid;
		this.CName=CName;
		student =new ArrayList<Student>();
	}
	
	public Integer getCid() {
		return Cid;
	}
	public void setCid(Integer cid) {
		Cid = cid;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCAddress() {
		return CAddress;
	}
	public void setCAddress(String cAddress) {
		CAddress = cAddress;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date2) {
		this.date = date2;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "课程编号:" + Cid + "\n课程名称:" + CName + "\n上课地址:" + CAddress + "\n上课时间:" + date + "\n学分:"
				+ credit + "\n授课教师:" +"\n学生:" ;
	}
	
}
