package com.joshua.easypass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("/role/[0-9]+");
		Matcher matcher = pattern.matcher("/role/4123123123123123");
		if(matcher.matches()) {
			System.out.println("匹配");
		}
	}

}
