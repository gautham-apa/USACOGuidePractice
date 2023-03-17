/*
ID: gautham15
LANG: JAVA
TASK: blist
*/

// http://www.usaco.org/index.php?page=viewproblem2&cpid=856

import java.io.*;
import java.util.*;

public class blist {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("blist.in"));
        PrintWriter out = new PrintWriter(new File("blist.out"));
        int n = br.nextInt();
        int[] arr = new int[1002];

        for(int i=0; i<n; i++) {
            int s = br.nextInt();
            int t = br.nextInt();
            int count = br.nextInt();
            arr[s] += count;
            arr[t+1] -= count;
        }
        int max = 0;
        for(int i=1; i<1002; i++) {
            arr[i] = arr[i-1]+arr[i];
            max = Math.max(arr[i], max);
        }
        out.println(max);
        out.close();
    }
}