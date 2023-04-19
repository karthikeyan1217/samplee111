package ppp.ada;

import java.util.Scanner;

public class JavaDemo {


//output = test12pop90avaj

	// Java code to illustrate how to reverse an array without
	// affecting special characters.
	public static void main(String[] args)
	{
		String str = "a!!!b.c.d,e'f,ghi";
		char[] charArray = str.toCharArray();

		System.out.println("Input string: " + str);
		reverse(charArray);
		String revStr = new String(charArray);

		System.out.println("Output string: " + revStr);
	}

		public static void reverse(char str[])
		{
			int r = str.length - 1, l = 0;

			while (l < r) {
				// Ignore special characters
				if (!Character.isAlphabetic(str[l]))
					l++;
				else if (!Character.isAlphabetic(str[r]))
					r--;

				// Both str[l] and str[r] are not spacial
				else {
					char tmp = str[l];
					str[l] = str[r];
					str[r] = tmp;
					l++;
					r--;
				}
			}
		}
}
		// Driver Code
		

	// This code is contributed by Sania Kumari Gupta
