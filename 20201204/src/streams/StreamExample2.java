package streams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1~100 숫자 가져오기
		// 짝수만 결과를 출력

		IntStream number = IntStream.range(1, 101);
		number.filter(a -> a % 2 == 0).forEach(a -> System.out.println(a));
		System.out.println("===============");

		IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0)//
				.forEach(n -> System.out.println(n));

		int sum = IntStream.rangeClosed(1, 100)//
				.filter(n -> n % 2 == 0).sum();
		System.out.println("짝수의 합계: " + sum);

		int[] intAry = { 2, 6, 4, 8, 1, 9 };

		IntStream aa = Arrays.stream(intAry);
		int min = aa.min().getAsInt();
		System.out.println(min);
		System.out.println("==============");

		IntStream bb = Arrays.stream(intAry);
		OptionalInt max = bb.max();
		System.out.println(max);
		int iMax = max.getAsInt();
		System.out.println(iMax);

		System.out.println("==============");

		aa = Arrays.stream(intAry);
		double avg = aa.average().getAsDouble();
		System.out.println(avg);

		// 조건(filter)
		Arrays.stream(intAry).filter(a -> a % 2 == 0)//
				.forEach(a -> System.out.println(a));

	}// end of main
}// end of class