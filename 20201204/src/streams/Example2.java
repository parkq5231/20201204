package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Example2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("김밥", 90), //
				new Student("만두", 60), //
				new Student("호빵", 80), //
				new Student("찐빵", 70));
		int sum = list.stream().mapToInt(t -> t.getScore()).sum();
		System.out.println("총합계: " + sum);

		int result = list.stream().mapToInt(t -> t.getScore()).reduce((left, right) -> left + right).getAsInt();
		System.out.println("결과값: " + result);

		result = list.stream().mapToInt(t -> t.getScore()).reduce(0, new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return left > right ? left : right;
			}
		});
		System.out.println("최대값: " + result);

		result = list.stream().mapToInt(t -> t.getScore()).reduce((a, b) -> (a + b) / 2).getAsInt();

		System.out.println(result);

	}// end of main
}// end of class
