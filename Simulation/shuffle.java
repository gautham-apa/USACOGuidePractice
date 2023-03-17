/*
ID: gautham15
LANG: JAVA
TASK: shuffle
*/

// http://www.usaco.org/index.php?page=viewproblem2&cpid=760

import java.io.*;
import java.util.*;

public class shuffle {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("shuffle.in"));
        PrintWriter out = new PrintWriter(new File("shuffle.out"));
        int n = br.nextInt();
        int[] shuf = new int[n];
        int[] res = new int[n];
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            shuf[i] = br.nextInt() - 1;
            arr[i] = i;
        }

        for(int i=0; i<n; i++) res[i] = br.nextInt();

        for(int i=0; i<3; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                temp[shuf[j]] = arr[j];
            }
            arr = temp.clone();
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[arr[i]] = res[i];
        }

        for(int i=0; i<n; i++) {
            out.println(ans[i]);
        }

        out.close();
    }
}