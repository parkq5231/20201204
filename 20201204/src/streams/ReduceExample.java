package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class ReduceExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(//
				new Student("HONG", 80), //
				new Student("HWANG", 90), //
				new Student("PARK", 87));

		int sum = list.stream().mapToInt(t -> t.getScore()).sum();
		System.out.println("합계: " + sum);

		// reduce
		int result = list.stream().mapToInt(t -> t.getScore())//
				.reduce(new IntBinaryOperator() {
					@Override
					public int applyAsInt(int left, int right) {
						System.out.println(left + "-" + right);
						return left + right;
					}
				}).getAsInt(); // reduce의 결과값을 getAsInt에 담겠다는 의미
		System.out.println("결과값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())//
				.reduce(0, (left, right) -> left + right);
		System.out.println("결과값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())//
				.reduce(0, (left, right) -> left > right ? left : right);
		System.out.println("최대값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())//
				.reduce(100, (left, right) -> left < right ? left : right);//
		System.out.println("최소값: " + result);

		result = list.stream()//
				.mapToInt(t -> t.getScore())//
				.reduce((a, b) -> (a + b) / 2)//
				.getAsInt();
		System.out.println("평균값: " + result);

	}// end of main
}// end of class