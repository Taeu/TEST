package d0706;

public class MemberDTO {
	private String id; 		// 회원 id
	private String pw; 		// 회원 pw
	private String name;	// 이름
	private String tel;		// 전화번호
	private String addr;	// 주소
	private String birth;	// 생년월일
	private String job;		// 직업
	private String gender;	// 성별
	private String email;	// 이메일
	private String intro;	// 소개
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	// 객체의 정보를 확인하기 위해 toString()을 오버라이드한다.
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", birth="
				+ birth + ", job=" + job + ", gender=" + gender + ", email=" + email + ", intro=" + intro + "]";
	}
	
} 