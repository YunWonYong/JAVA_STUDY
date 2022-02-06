package chapter3;

public class 드라마 {
	private int 시작일;
	private int 종료일;
	private String 배급사;
	private String 장르;
	private String 감독;
	// 4번 getter, setter
	public 드라마(int 시작일, int 종료일, String 배급사, String 장르, String 감독) {
		super();
		this.시작일 = 시작일;
		this.종료일 = 종료일;
		this.배급사 = 배급사;
		this.장르 = 장르;
		this.감독 = 감독;
	}

	public int Get시작일() {
		return 시작일;
	}	
	public void Set시작일(int 시작일) {
		this.시작일 = 시작일;
	}
	public int Get종료일() {
		return 종료일;
	}
	public void Set종료일(int 종료일) {
		this.종료일 = 종료일;
	}
	public String Get배급사() {
		return 배급사;
	}
	public void Set배급사(String 배급사) {
		this.배급사 = 배급사;
	}
	public String Get장르() {
		return 장르;
	}
	public void Set장르(String 장르) {
		this.장르 = 장르;
	}
	public String Get감독() {
		return 감독;
	}
	public void Set감독(String 감독) {
		this.감독 = 감독;
	}
	
}
