/*
ID: gautham15
LANG: JAVA
TASK: traffic
*/

import java.io.*;
import java.util.*;

public class traffic {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("traffic.in"));
        PrintWriter out = new PrintWriter(new File("traffic.out"));
        int n = br.nextInt();
        int resl = -1000000000;
        int resh = 1000000000;
        int[] startArr = new int[n];
        int[] endArr = new int[n];
        String[] typeArr = new String[n];

        for(int i=0; i<n; i++) {
            typeArr[i] = br.next();
            startArr[i] = br.nextInt();
            endArr[i] = br.nextInt();
        }

        // reverse direction
        for(int i=n-1; i>=0; i--) {
            int start = startArr[i];
            int end = endArr[i];
            String type = typeArr[i]; 

            if(type.equals("none")) {
                resl = Math.max(resl, start);
                resh = Math.min(resh, end);
            } else if(type.equals("on")) {
                resl -= end;
                resh -= start;
                resl = Math.max(0, resl);
                resh = Math.max(0, resh);
            } else {
                resl += start;
                resh += end;   
            }
        }
        out.println((resl)+" "+(resh));

        resl = -1000000000;
        resh = 1000000000;
        // forward direction
        for(int i=0; i<n; i++) {
            int start = startArr[i];
            int end = endArr[i];
            String type = typeArr[i]; 

            if(type.equals("none")) {
                resl = Math.max(resl, start);
                resh = Math.min(resh, end);
            } else if(type.equals("on")) {
                resl += start;
                resh += end;
            } else {
                resl -= end;
                resh -= start;
                resl = Math.max(0, resl);
                resh = Math.max(0, resh);
            }
        }

        out.println((resl)+" "+(resh));
        out.close();
    }
}