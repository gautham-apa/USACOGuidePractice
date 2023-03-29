/*
ID: gautham15
LANG: JAVA
TASK: measurement
*/

import java.io.*;
import java.util.*;

public class measurement {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("measurement.in"));
        PrintWriter out = new PrintWriter(new File("measurement.out"));
        int n = br.nextInt();
        int[][] arr = new int[101][2];
        while(n-- > 0) {
            int day = br.nextInt();
            String cow = br.next();
            int yield = Integer.valueOf(br.next());
            if(cow.equals("Bessie")) {
                arr[day][0] = 0;
                arr[day][1] = yield;
            } else if(cow.equals("Elsie")) {
                arr[day][0] = 1;
                arr[day][1] = yield;
            } else {
                arr[day][0] = 2;
                arr[day][1] = yield;
            }
        }
        String currPic = "012";
        int ans = 0;
        int[] curr = {7, 7, 7};
        for(int i=0; i<=100; i++) {
            curr[arr[i][0]] += arr[i][1];
            String nextPic = getPic(curr);
            if(!nextPic.equals(currPic)) ans++;
            currPic = nextPic;
        } 
        out.println(ans);
        out.close();
    }

    private static String getPic(int[] arr) {
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        String ans = "";
        for(int i=0; i<3; i++) {
            if(arr[i] == max) ans += i;
        }
        return ans;
    }
}