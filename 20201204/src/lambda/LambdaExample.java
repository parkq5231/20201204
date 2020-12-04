package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {
	static List<Student> list = Arrays.asList(new Student("Hong", "Male", 70), new Student("Hwang", "Female", 80),
			new Student("Park", "Male", 90), new Student("CHoi", "Female", 85));

	public static void main(String[] args) {

		// 여학생의 정보(이름,점수)
		System.out.println("1.여학생정보");
		for (Student student : list) {
			if (student.getSex().equals("Female")) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}
		// 전체학생 (점수 80점 초과)
		System.out.println("2.80점 초과 학생");
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + "-" + student.getSex() + "-" + student.getScore());
			}
		}
		// 남학생의 총점
		System.out.println("3.남학생 총점");
		int sum = 0;
		for (Student student : list) {
			if (student.getSex().equals("Male")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생의 총점:" + sum);
		// 여학생의 평균
		System.out.println("4.여학생의 평균");
		int count = 0;
		double sum1 = 0;
		for (Student student : list) {
			if (student.getSex().equals("Female")) {
				sum1 += student.getScore();
				count++;
			}
		}
		System.out.println(sum1 / count);
		// 람다1.여학생 정보
		System.out.println("여학생정보");
		femaleInfo((t) -> t.getSex().equals("Female"));
		
		System.out.println("===============");
		// Consumer<String> consumer = null;
		Stream<Student> stream = list.stream();
		stream.filter((t) -> t.getSex().equals("Female"))//
				.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore()));

		System.out.println("===============");
		// stream은 한번쓰면 소진되서 다시 만들어야함
		stream = list.stream();
		stream.filter(new Predicate<Student>() {// stream이 Student안에 있어서
			@Override
			public boolean test(Student t) {
				return t.getScore() > 80;
			}
		}).forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + "-" + t.getScore());
			}
		});

		int sum2 = list.stream().filter(t -> t.getSex().equals("Male")).mapToInt((value) -> value.getScore()).sum();
		System.out.println("남학생총점수: " + sum2);
		// Student에서 점수만 가져와서 밑에 sum에서 sum에 집계하겠다

		double avg = list.stream().filter(t -> t.getSex().equals("Female"))//
				.mapToInt(s -> s.getScore())//
				.average()//
				.getAsDouble();
		System.out.println("여학생평균: " + avg);

		// 흘려보낼준비완료. foreEach가 stream에 들어가있는걸 전부 실행시키겠다
		// 순서는 filter의 결과를 가져오고 루팅돌면서 내용 가져온 후 forEach는 그냥 for문을 간단하게 사용할 수 있는거라 생각ㄴ
	}// end of main
		// 람다
	public static void femaleInfo(Predicate<Student> pred) {
		for (Student student : list) {
			if (pred.test(student)) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}
	}
}// end of class
