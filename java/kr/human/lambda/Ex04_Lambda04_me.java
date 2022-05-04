package kr.human.lambda;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex04_Lambda04_me {
	// 인수가 1개, 리턴값이 1개 => Function 인터페이스를 사용

	// 바로 람다로 가자
	public static void main(String[] args) {
		// 정수를 문자로 변환하는 람다식
		Function<Integer, String> int2String = (a) -> (a + "");// 스트링으로 바꾸는 가장 간단한 방법
		System.out.println(int2String.apply(123) + 123);// 스트링과 숫자의 더하기라 그냥 스트링으로 더해져서 123123이 된다

		// 문자열을 정수로 변환하는 람다식
		Function<String, Integer> string2Int = (a) -> Integer.parseInt(a);
		System.out.println(string2Int.apply("2") * 123); // 246이 나온다

		// 인수가 없고 리턴값이 1개인 함수 => Supplier 인터페이스 구현
		// 0에서 100사이의 난수를 1개 얻는 람다식
		Supplier<Integer> rand100 = () -> (int)(Math.random()*101);
		//int로 안바꾸면 double로 소수 둘째자리까지 나오게 된다
		System.out.println(rand100.get());
		System.out.println(rand100.get());
		System.out.println(rand100.get());
		System.out.println(rand100.get());

		//인수가 1개 있고 리턴값이 없다(출력용이라는 의미) => Consumer 인터페이스를 쓰라는 의미
		Consumer<String> printMessage = str -> System.out.println("(" + str + ")");
		//인수가 하나이면 ()를 안써줘도 된다
		printMessage.accept("한사람");
		printMessage.accept("두사람");
		printMessage.accept("하하하");
		
		//정수 2개를 보내서 문자열로 결합해서 리턴하는 람다식
		BiFunction<Integer, Integer, String> add = (a, b) -> a + "" + b;
		System.out.println(add.apply(123, 456));
		
		
		//총점과 개수를 인수로 받아 평균을 소수이하 2자리로 만들어 String으로 리턴하는 함수
		BiFunction<Integer, Integer, String> avg = (a, b) -> String.format("%.2f", (double)a/b);
		System.out.println(avg.apply(100, 3));
		
	}
}
