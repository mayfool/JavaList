package myWork;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String stest = "这是一个a.test方法,版本v1.03。";
		String stest2 = "随便asdfasdf bcd bcd 99999 2.3";

		Pattern ptest = Pattern.compile("[a-z]+|[0-9]+(.[0-9]+)|[0-9]");
		// Pattern ptest=Pattern.compile("[0-9]+(.[0-9]{2})");

		Matcher mtest = ptest.matcher(stest);
		List<String> list = new ArrayList<>();
		while (mtest.find()) {
System.out.println(mtest.start());
System.out.println(mtest.end());
System.out.println(mtest.group());
			list.add(mtest.group());
			
		}
		System.out.println(list);
		// System.out.println(mtest.group(0));
		// mtest.matches();
		// System.out.println(mtest.toMatchResult());
		// System.out.println(mtest.end());

	}

}