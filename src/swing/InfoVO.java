package swing;

public class InfoVO {

	String tel;
	String name;
	String id;
	String gender;
	int age;
	String home;
	// 생성자
	
	
	public InfoVO() {
		super();
	}
	public InfoVO(String tel, String name, String id, String gender, int age, String home) {
		super();
		this.tel = tel;
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.home = home;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
	
	

}
