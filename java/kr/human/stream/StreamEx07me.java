package kr.human.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx07me {
	public static void main(String[] args) {
		IntStream
		.rangeClosed(1, 10)
		.map(n -> n*n)
		.forEach(n -> System.out.print(n + " "));
		System.out.println("\n" + "-".repeat(50));
		
		//사원목록에서 이름만 대문자로 한줄에 출력하시오
		Employee.persons().stream()
		.map(Employee::getName) // map으로 문자 하나씩 가져와서 이름만 스트림으로 만든다
		.forEach(n -> System.out.print(n.toUpperCase() + " "));
		
		// Stream map() 작업은 일대일 매핑을 생성합니다
		// Stream flatMap() 은 일대다 매핑을 지원합니다
		Stream
		.of(1,2,3,4,5)
		.flatMap(n -> Stream.of(n, n+1, n*2))//연속된 두개의 값을 스트림으로 만든다
		.forEach(n -> System.out.print(n + " ")); //반복출력
		System.out.println("\n" + "-".repeat(50));
		
		
	      Stream.of("XML", "JAVA", "HTML", "CSS")
	      .map(name->name.chars()) // 글자 하나씩 쪼개서 chars() : 문자열을 IntStream(코드숫자)으로 만들어 준다.
	      .flatMap(intStream -> intStream.mapToObj(n->(char)n)) // mapToObj로 가져와서 문자로 변환
	      .forEach(e->System.out.println(e)); // 출력
	      System.out.println("-------------------------------------------");
	      
	      Stream.of("XML", "JAVA", "HTML", "CSS")
	      .flatMap(name->IntStream.range(0, name.length()).mapToObj(name::charAt))
	      .forEach(e->System.out.println(e)); // 출력
	      System.out.println("-------------------------------------------");
	}
}
