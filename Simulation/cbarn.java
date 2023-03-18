/*
ID: gautham15
LANG: JAVA
TASK: cbarn
*/

// http://www.usaco.org/index.php?page=viewproblem2&cpid=616

import java.io.*;
import java.util.*;

public class cbarn {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("cbarn.in"));
        PrintWriter out = new PrintWriter(new File("cbarn.out"));
        int n = br.nextInt();
        int[] arr = new int[n];
        int total = 0;
        for(int i=0; i<n; i++) {
            arr[i] = br.nextInt();
            total += arr[i];
        } 
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int sum = 0, temp = total;
            for(int j=0; j<n; j++) {
                temp -= arr[(i+j) % n];
                sum += temp;
            }
            ans = Math.min(ans, sum);
        }
        out.println(ans);
        out.close();
    }
}