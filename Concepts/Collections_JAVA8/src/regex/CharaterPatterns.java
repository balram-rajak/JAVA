package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CharaterPatterns {

	public static void findStringPattern(String inputLine,String pattern) {
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(inputLine);
		System.out.println(pattern);
		while(m.find()) System.out.println(m.start()+"------"+m.end()+"------"+m.group());
	}
	public static void emailValidation(String inputLine,String pattern) {
		findStringPattern(inputLine, pattern);
		System.out.println(
				Stream.of(inputLine.split("@")[0].split("\\d+"))
				.anyMatch(t -> t.matches("[a-zA-Z]+")));
		
	}
	public static void split(String inputLine,String pattern) {
		Pattern p=Pattern.compile(pattern);
		String[] s=p.split(inputLine);
		Stream.of(s).forEach(System.out::println);
	}
	public static void main(String[] args) {
		String noiseWord="CORPORATION";
		findStringPattern("ababaabbbaab", "ab");
		findStringPattern("afj@845#gbh", "[abc]");
		findStringPattern("afj@845#gbh", "[^abc]");
		findStringPattern("afj@845#gbh", "[a-z]");
		findStringPattern("afj@845#gbh", "[^a-z]");
		findStringPattern("afj@845#gbh", "[0-9]");
		findStringPattern("afj@845#gbh", "[a-zA-Z0-9]");
		findStringPattern("afj@845#gbh", "[^a-zA-Z0-9]");
		findStringPattern("Shangai corporation .,& LTD. ,", "[^\\w0-9]*"+noiseWord+"[^\\w0-9]*\s");
		findStringPattern("LTD. Shangai corporation .,&  ,", "[^\\w0-9]*"+noiseWord+"[^\\w0-9]*\s");
		findStringPattern("LTD. Shangai, LTD. corporation .,&  ,", "[\\s||^\\w0-9]*"+noiseWord+"[^\\w0-9]*\\s");
		findStringPattern("C L Design and Consulting (CORPORATION) Corp", "[^\\w\\s]?"+noiseWord+"([^\\w0-9]+|\\s|$)");
		split("falana3245$gmail$cytrgo", "$");
		emailValidation("falana3245@gmail.cytrgo", "[\\da-zA-Z]+\\@[a-zA-Z]{4,6}[.][a-zA-Z]{2,6}$");
		findStringPattern("falana3245@gmail.cytrgo",
				"([a-zA-Z_]+\\d*|\\d*[a-zA-Z_]+)\\@[a-zA-Z]{4,6}[.][a-zA-Z]{2,6}$");
		findStringPattern("falana324ty5@gmail.cytrgo",
				"([a-zA-Z_]+\\d*|\\d*[a-zA-Z_]+)\\@[a-zA-Z]{4,6}[.][a-zA-Z]{2,6}$");
		findStringPattern("3245@gmail.cytrgo",
				"([a-zA-Z]+\\d*|\\d*[a-zA-Z]+)\\@[a-zA-Z]{4,6}[.][a-zA-Z]{2,6}$");
		findStringPattern("+919340544987", "\\+[1-9]{1,2}[789]\\d{9}|0?[789]\\d{9}");
		findStringPattern("9340542977", "\\+[1-9]{1,2}[789]\\d{9}|0?[789]\\d{9}");
		findStringPattern("09340542977", "\\+[1-9]{1,2}[789]\\d{9}|0?[789]\\d{9}");
		findStringPattern("9340542977", "(\\+[1-9]{1,2}|0)?[789]\\d{9}");
		findStringPattern("9292929292", "^(\\+[1-9]{1,2}|0)?[789]\\d{9}$");
		findStringPattern("9292929292929", "^(\\+[1-9]{1,2}|0)?[789]\\d{9}$");
//		findStringPattern("adg sss,data1,data2,data3,eee ack blah blah received",
//				"sss(.*?)eee|ack(.*?)received");
		findStringPattern("a6ttf$","[a-k][0369][\\w$#]*");
		findStringPattern("bavil","[a-zA-Z]+[lL]$");
		findStringPattern("krishnaradha","^[^'\"]*$");
		
		
		
		
	}
}
