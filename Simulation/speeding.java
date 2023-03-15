/*
ID: gautham15
LANG: JAVA
TASK: lostcow
*/

import java.io.*;
import java.util.*;

public class speeding {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("speeding.in"));
        PrintWriter out = new PrintWriter(new File("speeding.out"));
        int m = br.nextInt(); int n = br.nextInt();
        int[] allowed = new int[100];

        int pos = 0;
        for(int i=0; i<m; i++) {
            int end = br.nextInt(); int speed = br.nextInt();
            for(int j=0; j<end; j++) {
                allowed[pos++] = speed;
            }
        }

        pos = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            int end = br.nextInt(); int speed = br.nextInt();
            for(int j=0; j<end; j++) {
                ans = Math.max(speed-allowed[pos++], ans);
            }
        }

        out.println(ans);
        out.close();
    }
}