package com.case6.quizchallengeweb.controller;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Integer a = Integer.valueOf(1);
		int b = 1000;
		for (int i = 0; i < 1_000; i++) {
			b += 2000;
		}
		List<Integer> list = Arrays.asList(b);
		System.out.println(a == 1);
		System.out.println(list.get(0) == 1000);
		int c = a + b;
		int d = a; // int d = a.intValue();
		System.out.println(d);
		System.out.println(c == 1001);
		System.out.println(c);
	}

}
