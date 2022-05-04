package kr.human.lambda;

import java.util.function.Predicate;

public class Ex03_Lambda03 {
	//문자열의 길이가 0인지 판단하는 함수를 만들어서 사용하자
	// 인수가 1개, 리턴값이 boolean => Predicate를 사용
	
	// 지금까지의 방식
	public static boolean isEmpty(String str) {
		return str != null && str.length() == 0;
	}
	
	public static void main(String[] args) {
		// 지금까지의 방식
		//함수형 인터페이스를 구현해서 사용
		Predicate<String> pre = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t != null && t.length() == 0;
			}
		};
		System.out.println(isEmpty(null) ? "있다" : "없다");
		System.out.println(isEmpty("") ? "있다" : "없다");
		System.out.println(isEmpty("하하하") ? "있다" : "없다");
		System.out.println("-".repeat(40));
		
		System.out.println(pre.test(null) ? "있다" : "없다");
		System.out.println(pre.test("") ? "있다" : "없다");
		System.out.println(pre.test("하하하") ? "있다" : "없다");
		System.out.println("-".repeat(40));
		
		//함수형 인터페이스를 람다로 구현해서 사용
		Predicate<String> pre2 = (t) -> t != null && t.length() == 0;

		System.out.println(pre2.test(null) ? "있다" : "없다");
		System.out.println(pre2.test("") ? "있다" : "없다");
		System.out.println(pre2.test("하하하") ? "있다" : "없다");
		
	}
	
}
