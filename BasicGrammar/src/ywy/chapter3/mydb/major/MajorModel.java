package ywy.chapter3.mydb.major;

public class MajorModel {
	private String majorCode;
	private String professorHeadUserCode;
	private String majorName;
	private String majorPhoneNumber;
	private String useYn;
	
	public MajorModel() {
		// TODO Auto-generated constructor stub
	}

	public MajorModel(String majorCode, String professorHeadUserCode, String majorName, String majorPhoneNumber,
			String useYn) {
		super();
		this.majorCode = majorCode;
		this.professorHeadUserCode = professorHeadUserCode;
		this.majorName = majorName;
		this.majorPhoneNumber = majorPhoneNumber;
		this.useYn = useYn;
	}

	
	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getProfessorHeadUserCode() {
		return professorHeadUserCode;
	}

	public void setProfessorHeadUserCode(String professorHeadUserCode) {
		this.professorHeadUserCode = professorHeadUserCode;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorPhoneNumber() {
		return majorPhoneNumber;
	}

	public void setMajorPhoneNumber(String majorPhoneNumber) {
		this.majorPhoneNumber = majorPhoneNumber;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "MajorModel [majorCode=" + majorCode + ", professorHeadUserCode=" + professorHeadUserCode
				+ ", majorName=" + majorName + ", majorPhoneNumber=" + majorPhoneNumber + ", useYn=" + useYn + "]";
	}
}
