package kr.human.lambda;

import java.util.function.Predicate;

public class Ex02_Lambda02 {
	// 인수도 없고 리턴값도 없다 => Runnable를 사용
	
	public static void main(String[] args) {
		System.out.println("하하하하");
		System.out.println("\n");//빈줄 2개 출력하는 효과
		System.out.println("하하하하");
		//중간에 빈줄이 발생-> 이 공백을 넓히고 싶다
		
		//람다로 표현해보자
		Runnable blankDoubleLine = () -> System.out.println("\n");
		System.out.println("하하하하");
		blankDoubleLine.run();//빈줄 2개 출력
		System.out.println("하하하하");
		
		Runnable Line = () -> System.out.println("-".repeat(50));
		System.out.println("하하하하");
		Line.run();//한줄 선 그리기
		System.out.println("하하하하");
		
		
	}
	
}
