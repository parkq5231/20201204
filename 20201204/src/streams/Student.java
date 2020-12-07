package streams;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {// 여기가 정의하는 기준점
		return o.score - this.score;//내림차순 
	}
//		if (this.score < o.score) {// 음수값인경우
//			return -1;
//		} else
//			return 1;
//	}	
	// return this.score > o.score ? 1: -1;과 같은 값

}// end of class