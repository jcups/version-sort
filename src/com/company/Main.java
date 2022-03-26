package com.company;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] versions = new String[]{
				"10.3.2.1", "3.2", "5.7.5.5.6.5", "5.7.5.5.6.7", "10.3.2.2", "1.0.0.2", "0.0.0.5",
				"5.7.5.9", "5.7.5.5.6.8", "1.0.0.1", "10.2.3.1"};

		Arrays.sort(versions, (ver1, ver2) -> {
			String[] ver1Split = ver1.split("\\.");
			int[] var1 = Arrays.stream(ver1Split.length == 0 ?
					new String[]{ver1} : ver1Split).mapToInt(Integer::parseInt).toArray();

			String[] ver2Split = ver2.split("\\.");
			int[] var2 = Arrays.stream(ver2Split.length == 0 ?
					new String[]{ver2} : ver2Split).mapToInt(Integer::parseInt).toArray();

			for (int i = 0; i < Math.min(var1.length, var2.length); i++) {
				if (var1[i] < var2[i])
					return -1;
				else if (var1[i] > var2[i])
					return 1;
			}
			return 0;
		});

		System.out.println("result = " + Arrays.toString(versions));
	}
}
