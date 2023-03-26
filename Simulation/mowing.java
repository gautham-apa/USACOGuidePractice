/*
ID: gautham15
LANG: JAVA
TASK: mowing
*/

import java.io.*;
import java.util.*;

public class mowing {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("mowing.in"));
        PrintWriter out = new PrintWriter(new File("mowing.out"));
        int ans = Integer.MAX_VALUE;
        int n = br.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int x = 0, y = 0, time=1;
        map.put(x+""+y, 0);
        while(n-- > 0) {
            char dir = br.next().charAt(0);
            int dist = br.nextInt();
            for(int i=0; i<dist; i++) {
                if(dir == 'N') y++;
                else if(dir == 'S') y--;
                else if(dir == 'E') x++;
                else if(dir == 'W') x--;

                String key = x+"#"+y;
                
                if(map.containsKey(key)) {
                    ans = Math.min(time-map.get(key), ans);
                }
                map.put(key, time);
                time++;
            }
        }
        if(ans == Integer.MAX_VALUE) out.println("-1");
        else out.println(ans);
        out.close();
    }
}