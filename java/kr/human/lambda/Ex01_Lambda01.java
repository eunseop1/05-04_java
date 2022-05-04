package kr.human.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface MyFunction{
	int max(int a, int b);
}


public class Ex01_Lambda01 {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("일식이", "두식이", "삼식이", "간나새끼");
		System.out.println(names);
		
		//가나다 순으로 정렬해서 출력해보자
		Collections.sort(names);
		System.out.println(names);
		
		//역순으로 출력해보자 => 기존의 방식
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});//다만 여기가 1회용이기에 람다로 바꿔보자
		System.out.println(names);
		
		// 위의 Comparator 인터페이스는 익명 객체 => 람다식으로 변경 가능. 1회용이기에 가능
		//람다식 : 이름이 없는 메소드
		Collections.sort(names,(o1, o2) -> o2.compareTo(o1));
		System.out.println(names);
		Collections.sort(names,(o1, o2) -> o1.compareTo(o2));
		System.out.println(names);
		System.out.println("-".repeat(40));
		
		// 2초 후에 HelloWorld를 출력하는 스레드를 만들자
		new Thread(new Runnable() {	
			@Override
			public void run() {//아무 의미없는 익명함수
				try {
					Thread.sleep(2000); //일정시간 대기 -> 1/1000단위이기에 2초대기
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hello World!");
			}
		}).start();
		
		
		//Runnable 인터페이스를 람다식으로 표현
		new Thread(()->{System.out.println("나는 언제 실행되나?");}).start();
		//중괄호도 쓸수 있다는 것을 보여주기 위해 일부러 사용
		
		//사용자가 만든 인터페이스의 일반 사용
		System.out.println(new MyFunction() {
			
			@Override
			public int max(int a, int b) {
				return a>b ? a : b;
			}
		}.max(10, 23)); //MyFunction 인터페이스를 구현함과 동시에 객체를 생성하고 메소드 호출까지
		
		//사용자가 만든 인터페이스의 람다식으로 사용
		MyFunction mf = (a,b) -> a > b ? a: b;
		System.out.println(mf.max(22,12));
	}
}
