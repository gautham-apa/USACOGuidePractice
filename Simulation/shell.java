/*
ID: gautham15
LANG: JAVA
TASK: shell
*/

// USACO 2019 January Contest, Bronze
// Problem 1. Shell Game
// http://www.usaco.org/index.php?page=viewproblem2&cpid=891

import java.io.*;
import java.util.*;

public class shell {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("shell.in"));
        PrintWriter out = new PrintWriter(new File("shell.out"));

        int n = br.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            arr[i][0] = br.nextInt() - 1;
            arr[i][1] = br.nextInt() - 1;
            arr[i][2] = br.nextInt() - 1;
        }

        int ans = 0;
        for(int i=0; i<3; i++) {
            int pos = i;
            int tempAns = 0;
            for(int j=0; j<n; j++) {
                if(arr[j][0] == pos) pos = arr[j][1];
                else if(arr[j][1] == pos) pos = arr[j][0];
                if(pos == arr[j][2]) tempAns++;
            }
            ans = Math.max(ans, tempAns);
        }
        out.println(ans);
        out.close();
    }
}