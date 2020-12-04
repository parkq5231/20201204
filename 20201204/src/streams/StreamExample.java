package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
		list = Arrays.asList("HONG", "HWANG", "PARK", "CHOI");// Arrays.하면 많이 추가할 수 있음

		// 중간처리 메소드(filter)는 무조건 최종처리 메소드가 있어야 결과값이 나옴
		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3).forEach((t) -> System.out.println(t));

		// BaseStream -> Stream<T>,IntStream,LongStream,DoubleStream
		// IntStream: Stream<Integer> 의 경우 데이터 타입이 INT
		// LongStream: Stream<Long> 위와 동일 Long

		// 배열을 통해 Stream생성 가능 예시

		String[] strAry = { "Hong", "Hwang", "Park" };
		Stream<String> strStream = Arrays.stream(strAry);

		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();// 각각의 결과를 다 더해주는 sum()메소드
		System.out.println("합: " + sum);

		double[] dblAry = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		DoubleStream dblStream = Arrays.stream(dblAry);
		dblStream.forEach(new DoubleConsumer() {// forEach는 dblStream의 각각의 값을 처리하겠다
			double result = 0;

			@Override
			public void accept(double value) {
				result += value;
				System.out.println(result);
			}
		});
		System.out.println("=================");

		IntStream is = IntStream.range(1, 10);// 1~9까지
		// is.forEach(n -> System.out.println(n));
		is = IntStream.rangeClosed(1, 10);// 1~10까지 전부 합
		System.out.println("합: " + is.sum());

		// Path 파일정보 불러옴
		// 정확히는 파일 입출력
		Path path = Paths.get("list.txt");
		try {
			Stream<String> stream1 = Files.lines(path);// Files.lines()가 포인트
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 디렉토리 정보 불러옴
		path = Paths.get("c:/Program Files");
		try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}// end of main
}// end of class