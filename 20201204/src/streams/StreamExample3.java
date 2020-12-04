package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {

		String[] strs = "Java8-lambda-Hello".split("-");// split안의 내용을 기준으로 나눠서 배열로 만들어 주겠다는 의미

		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");

		strList.stream()// 똑같은 방식으로 줄이면 됨
				.flatMap(new Function<String, Stream<String>>() {// String 값을 받아서 또다른 Stream값을 만들어주는 메소드
					@Override
					public Stream<String> apply(String t) {
						return Arrays.stream(t.split(" "));// 배열을 stream 형태로
					}
				}).filter(s -> s.startsWith("s"))//
				.forEach(s -> System.out.println(s));

		strList.stream()//
				.map((t) -> t.toUpperCase())//
				.forEach(s -> System.out.println(s));
		// map은 리턴 타입만 정해주면 알아서 Stream을 만들어줌

		List<Student> students = Arrays.asList(new Student("송다희", "F", 80), new Student("윤태현", "M", 75),
				new Student("이혜빈", "F", 85), new Student("정병기", "M", 90));
		// 뭔가 만들 때 stream 메소드 사용
		double avg = students.stream()//
				.mapToInt(a -> a.getScore())//
				.average().getAsDouble();
		System.out.println(avg);

	}// end of main
}// end of class