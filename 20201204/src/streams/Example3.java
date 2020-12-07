package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Example3 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("HONG", 80), //
				new Student("HWANG", 90), //
				new Student("PARK", 87)//
		);

		List<Student> students = list.stream().filter(t -> t.getScore() / 10 == 8).sorted()//
				.collect(Collectors.toList());

		for (Student student : students) {
			System.out.println("이름: " + student.getName() + " ㅈㅁ수: " + student.getScore());
		}
		System.out.println("================");

		Map<String, Integer> map = list.stream().filter(t -> t.getScore() / 10 == 8).sorted()
				.collect(Collectors.toMap((t) -> t.getName(), (t) -> t.getScore()));
		Set<String> set = map.keySet();
		for (String key: set) {
			System.out.println("KEY: "+key+"VALUE: "+map.get(key));
		}

	}// end of main
}// end of class