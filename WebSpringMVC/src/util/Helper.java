package util;

import java.util.Random;

public class Helper {
	private final static String pattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static String randomString(int len) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i =0; i<len;i++) {
			sb.append(pattern.charAt(rand.nextInt(pattern.length())));
		}
		return sb.toString();
	}
}
