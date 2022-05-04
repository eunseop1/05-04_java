package kr.human.stream;

import java.util.stream.IntStream;

//1부터 만까지 8은 몇번 나오나? 888은 8이 세번나온걸로 친다
public class CodingDojang_google_8의개수 {
	public static void main(String[] args) {
		/*
		long count = IntStream.rangeClosed(1, 10000) //1~만까지 스트림
		.mapToObj(n -> n+ "") //문자열로 변환
		.filter(str -> str.contains("8")) //8이 들어있는 것만 고르고
		.map(str -> str.chars()) // 한글자씩 잘라서
		.flatMap(intStream -> intStream.mapToObj(n -> (char)n)) //char로 만들고
		.filter(n -> n == '8')//값이 8인 것만 골라서
		.count();//개수세기
		System.out.println("8의 개수 : "+ count + "개");
		*/
		long count = IntStream.rangeClosed(1, 10000)
		.mapToObj(n -> n+ "")
		.collect(Collectors.joining()) //모두 붙여서
		.chars() //한 글자씩 잘라서
		.filter(n -> n == '8')
		.count();
		System.out.println("8의 개수 : "+ count + "개");
	}	
}
