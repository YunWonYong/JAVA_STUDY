package chapter3;


public class Dog2 {
	public static class Build { // 내부 정적 클래스
		private String name;
		private int age;
		private String sound;
		private String color;
		private String size;
		
		public Build name(String name) {
			this.name = name;
			return this;
		}
		
		public Build age(int age) {
			this.age = age;
			return this;
		}
		
		public Build sound(String sound) {
			this.sound = sound;
			return this;
		}
		
		public Dog2 build() {
			if (name == null || age == 0 || sound == null) {
				throw new IllegalArgumentException();
			}
			return new Dog2(this);
		}
	}
	
	private Build build;

	private Dog2() {}
	
	private Dog2(Build build) {
		this.build = build;
	}
	
	public String getName() {
		return build.name;
	}
	public void setName(String name) {
		build.name = name;
	}
	public int getAge() {
		return build.age;
	}
	public void setAge(int age) {
		build.age = age;
	}
	public String getSound() {
		return build.sound;
	}
	public void setSound(String sound) {
		build.sound = sound;
	}
	public String getColor() {
		return build.color;
	}
	public void setColor(String color) {
		build.color = color;
	}
	public String getSize() {
		return build.size;
	}
	public void setSize(String size) {
		build.size = size;
	}
}
