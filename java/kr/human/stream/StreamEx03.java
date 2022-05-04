package kr.human.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx03 {
	public static void main(String[] args) {
		//중간연산
		
		//20~30까지 출력하라
		//limit(개수) : 개수제한 중간 연산
		Stream.iterate(20, n -> n+1).limit(11).forEach(n -> System.out.println(n + " "));
		System.out.println();
		
		//21 부터 홀수 10개 출력
		Stream.iterate(21, n -> n+2).limit(10).forEach(n -> System.out.println(n + " "));
		System.out.println();
		
		//21 부터 홀수 10개 출력
		Stream.iterate(21, n -> n+1) //무한 스트림
		.filter(n -> n%2 == 1) //걸러준다 : 중간연산
		.limit(10)
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		Stream.iterate(21, n -> n+1) //무한 스트림
		.filter(StreamEx03::isOdd) //걸러준다 : 중간연산
		.limit(10)
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// 1부터 홀수 중 100번째 부터 10개 중에서 3의 배수만
		Stream
		.iterate(1, n -> n+2) //무한 스트림
		.skip(100)//100개 건너뛰기
		.limit(10) //10개
		.filter(n -> n%3 == 0) //걸러준다 : 중간연산
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// 실수 난수 10개
		Stream
		.generate(Math::random)
		.limit(10) //10개
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		//사용자가 만든 정적 메서드를 이용하여 generate하기
		Stream
		.generate(StreamEx03::next)
		.limit(10) //10개
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		//객체 메서드를 호출하여 generate하기
		Stream
		.generate(new Random()::nextInt)
		.limit(10) //10개
		.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		new Random().ints().limit(10).forEach(n -> System.out.print(n + " "));
		System.out.println();

		new Random().ints(1, 101).limit(10).forEach(n -> System.out.print(n + " "));
		System.out.println();
		//1부터 100까지	리미트로 10개
		
		new Random().ints(5, 100, 201).forEach(n -> System.out.print(n + " "));
		System.out.println();
		//5개를 100부터 201까지
		
	}
	
	static int count = 1;
	public static int next() {
		count *= 2;
		return count;
	}
	
	public static boolean isOdd(int n) {
		return n%2 == 1;
	}
}
