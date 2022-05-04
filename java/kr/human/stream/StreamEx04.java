package kr.human.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamEx04 {
	public static void main(String[] args) {
		// 중간 연산 : filter
		String str = "1234,qwerty,3,12,6";

		str.chars()
				// !Character.isWhitespace ((char)n) &&
				.filter(n -> !Character.isDigit((char) n) && ((char) n != ','))//숫자도 아니면서 ,도 아니면
				.forEach(n -> System.out.print((char) n));
		System.out.println();

		str.chars()
		.filter(n -> !"1234567890,".contains((char) n + ""))
		.forEach(n -> System.out.print((char) n));
		System.out.println();

		str.chars()
		.filter(n -> Character.isAlphabetic((char) n))//알파벳이라면
		.forEach(n -> System.out.print((char) n));
		System.out.println();

		// 정규표현식을 이용한 스트림 만들기
		str = "XML,CSS,HTML";
		Pattern.compile(",")// 패턴으로도 스트링을 만들수 있다. 구분자는 , 이다
		.splitAsStream(str) //str을 구분자로 잘라서 스트림으로 만든다
		.forEach(System.out::println);

		// 파일을 이용한 스트림 만들기
		Path path = Paths.get("pom.xml");
		try (Stream<String> lines = Files.lines(path)) { //읽자마자 바로 스트림으로 만든다
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파일 목록 보기
		Path dir = Paths.get("."); //경로에서 .하나는 현재폴더, ..은 부모 폴더를 의미한다
		System.out.printf("%nThe file tree for %s%n", dir.toAbsolutePath());
		try (Stream<Path> fileTree = Files.walk(dir)) { // 경로들을 스트림으로 만든다
			fileTree.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
