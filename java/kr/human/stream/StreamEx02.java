package kr.human.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx02 {
	public static void main(String[] args) {
		//스트림을 만드는 방법
		// 1. list로 부터 만들기
		Stream<Integer> intStream = Arrays.asList(1,2,3,4,5).stream();
		System.out.println(intStream); //객체다. toString()이 오버라이딩 되어 있지 않다
		intStream.forEach(System.out::println);//정적메소드 호출 -> 최종연산, 1회성
		
		// 2. 배열로부터 만들기
		Stream<String> strStream = Stream.of("일식이,두식이,삼식이".split(","));
		strStream.forEach(System.out::println);
		
		
		// 3. iterate() 메소드로 만들기
		Stream<Integer> intStream2 = Stream.iterate(100, n -> n + 2);//100부터 짝수 스트림
		intStream2.limit(10).forEach(System.out::println);
		Stream<Integer> intStream3 = Stream.iterate(1, n -> n + 2);//1부터 홀수 스트림
		intStream3.limit(10).forEach(System.out::println);
		
		//4. generate()를 이용한 스트림 생성
		Stream<Double> doubleStream = Stream.generate(Math::random);//static메서드 호출
		doubleStream.limit(10).forEach(System.out::println);
		
		//---이 아래부터는 잘 안쓰인다
		//5. Random클래스르 이용한 스트림 생성
		IntStream intSctream4 = new Random().ints();
		intSctream4.limit(10).forEach(System.out::println);
		
		//6.값으로부터 스트림 만들기
		Stream<String> strStream2 = Stream.of("정말 재미없는 자바 스트림!!!");//값 1개가 1개의 데이터
		strStream2.forEach(System.out::println);
		Stream<String> strStream3 = Stream.of("한놈","두식","석삼");//값 1당 1개의 데이터
		strStream3.forEach(System.out::println);
		
		// 7. builder()를 이용한 스트림 만들기
		Stream<String> strStream4 = Stream.<String>builder().add("한놈").add("두식이").add("셋").build();
		strStream4.forEach(System.out::println);
		
		// 8. range()를 이용한 스트림만들기 -> 범위를 지정해야 하니 숫자
		IntStream intStream5 = IntStream.range(1, 10); //1 ~ n-1까지
		intStream5.forEach(System.out::println);
		IntStream intStream6 = IntStream.rangeClosed(1, 10); //1 ~ n까지
		intStream6.forEach(System.out::println);
		
		//9. empty()를 이용한 스트림 생성 : 비어있는 스트림
		Stream<String> strStream5 = Stream.empty();
		strStream5.forEach(System.out::println);
		
	}
}
