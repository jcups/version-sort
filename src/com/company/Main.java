package com.company;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] versions = new String[]{
				"10.3.2.1", "3.2", "5.7.5.5.6.5", "5.7.5.5.6.7",
				"5.7.5.9", "5.7.5.5.6.8", "1.0.0.1", "10.2.3.1"};
		
		Arrays.sort(versions, (ver1, ver2) -> {
			int[] var1 = Arrays.stream(ver1.split("\\.")).mapToInt(Integer::parseInt).toArray();
			int[] var2 = Arrays.stream(ver2.split("\\.")).mapToInt(Integer::parseInt).toArray();
			if (var1 == null)
				var1 = new int[]{Integer.parseInt(ver1)};
			if (var2 == null)
				var2 = new int[]{Integer.parseInt(ver2)};
			if (var1[0] < var2[0]) {
				return -1;
			} else if (var1[0] > var2[0]) {
				return 1;
			} else {
				for (int i = 1; i < Math.min(var1.length, var2.length); i++) {
					if (var1[i] < var2[i])
						return -1;
					else if (var1[i] > var2[i])
						return 1;
				}
				return 0;
			}
		});

		System.out.println("result = " + Arrays.toString(versions));
	}
}
