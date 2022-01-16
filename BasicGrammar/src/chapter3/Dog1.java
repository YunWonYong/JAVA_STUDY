package chapter3;


public class Dog1 {
	private String name;
	private int age;
	private String sound;
	private String color;
	private String size;
	
	public Dog1() {
		this("");
	}
	
	// 오버로딩의 정의: 함수명은 같고 파라메터의 갯수와 순서에 따라 결정된다.
	public Dog1(String name) {
		this(name, 0); // 호출 생성자
	}

	public Dog1(String name, int age) {
		this(name, age, "");
	}
	
	public Dog1(String name, int age, String sound) {
		this(name, age, sound, "", "");
	}
	
	public Dog1(String name, int age, String sound, String color) {
		this(name, age, sound, color, "");
	}

	public Dog1(String name, int age, String sound, String color, String size) {
		super();
		this.name = name;
		this.age = age;
		this.sound = sound;
		this.color = color;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Dog1 [name=" + name + ", age=" + age + ", sound=" + sound + ", color=" + color + ", size=" + size + "]";
	}
}
