package kr.human.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ex05_Lambda05 {
	public static void main(String[] args) {
		//매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스
		// UnatyOperator<T> : 인수 1개, 리턴 1개
		// BinaryOperator<T> : 인수2개 리턴 1개
		UnaryOperator<Integer> doubleValue = (i) -> (i*2);
		System.out.println(doubleValue.apply(4));
		System.out.println(doubleValue.apply(9));
		
		System.out.println(Math.pow(2, 10));//승을 구해준다
		

		//최대값/최소값을 구하고 싶다
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) list.add((int)(Math.random()*101));//0~100까지의 난수초기화
		System.out.println(list);
		
		int max = list.get(0) , min = list.get(0);//배열이나 컬렉션일 경우 첫번째 값으로 초기화
		for(int i : list) {
			if(max < i) max = i;
			if(min > i) min = i;
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
		// 최대/최소 구하기를 람다식으로 해보자
		BinaryOperator<Integer> maxF = (n, m) -> n < m ? m : n;
		BinaryOperator<Integer> minF = (n, m) -> n > m ? m : n;
		
		max = list.get(0); min = list.get(0);
		for(int i : list) {
			max = maxF.apply(max, i);
			//max = Math.max(max, i);도 가능
			min = minF.apply(min, i);
			//min = Math.min(min, i);도 가능
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
