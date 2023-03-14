/*
ID: gautham15
LANG: JAVA
TASK: mixmilk
*/

// USACO 2018 December Contest, Bronze
// Problem 1. Mixing Milk
// http://www.usaco.org/index.php?page=viewproblem2&cpid=855

import java.io.*;
import java.util.*;

public class mixmilk {
	public static void main(String[] args) throws IOException {
		Scanner br = new Scanner(new File("mixmilk.in"));
        PrintWriter out = new PrintWriter(new File("mixmilk.out"));

		int[] c = new int[3];
		int[] m = new int[3];
		for(int i=0; i<3; i++) {
			c[i] = br.nextInt();
			m[i] = br.nextInt();
		}

		for(int i=0; i<100; i++) {
			int p1 = i%3;
			int p2 = (i+1)%3;
			int m1 = m[p1];
			int c1 = c[p1];
			int m2 = m[p2];
			int c2 = c[p2];
			int newM2 = Math.min(m1+m2, c2);
			int amtTransfer = newM2 - m2;
			int newM1 = m1 - amtTransfer;
			m[p1] = newM1;
			m[p2] = newM2;
		}
		for(int i=0; i<3; i++) {
			out.println(m[i]);
		}
        out.close();
	}
}