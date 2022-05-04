package kr.human.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx05 {
	public static void main(String[] args) {
		//스트림은 읽기만 가능하다. 변경하지 못한다 -> 불변객체
		//그래서 중간연산을 하면 새로운 스트림이 리턴
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		
		//Collect 연산 : 만들어라 -- 최종연산
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		//리스트를 정렬한 다음 toList로 받아라
		System.out.println(list);
		System.out.println(sortedList);
		
		System.out.println(sortedList.stream().count() + "개");//최종연산
		
		// peek(Consumer<? super T> action)메서드를 이용하여 디버깅 가능하다
		int sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
				.peek(n -> System.out.println("가져오기: " + n))
				.filter(n -> n%2 == 1) //홀수들을 거른다
				.peek(n -> System.out.println("거르기: " + n))
				.map(n -> n*n) //각각의 요소들을 변경하여 새로운 스트림을 만든다
				.peek(n -> System.out.println("변환: " + n))
				.reduce(0, Integer::sum); // 모든 요소에 대해 반복하는 최종연산, 0에 더하면서 합계
		System.out.println("합계: " + sum); // 1*1 + 3*3 + 5*5 + 7*7 + 9*9
		
		
		
	}
}
