/*
ID: gautham15
LANG: JAVA
TASK: cowsignal
*/

// USACO 2016 December Contest, Bronze
// Problem 3. The Cow-Signal
// http://www.usaco.org/index.php?page=viewproblem2&cpid=665

import java.io.*;
import java.util.*;

public class cowsignal {
	public static void main(String[] args) throws IOException {
		Scanner br = new Scanner(new File("cowsignal.in"));
        PrintWriter out = new PrintWriter(new File("cowsignal.out"));
        int m = br.nextInt();
        int n = br.nextInt();
        int k = br.nextInt();
        br.nextLine();
        char[][] res = new char[m*k][n*k];
        int i=0;
        while(i<m*k) {
            System.out.println(i);
            char[] row = br.nextLine().toCharArray();
            for(int l=0; l<k; l++) {
                int pointer = 0;
                for(int j=0; j<n; j++) {
                    int x = pointer;
                    while(x < pointer+k) res[i][x++] = row[j];
                    pointer = x;
                }
                i++;
            }
        }

        for(i=0; i<m*k; i++) {
            out.println(String.valueOf(res[i]));
        }
        out.close();
	}
}