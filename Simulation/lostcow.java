/*
ID: gautham15
LANG: JAVA
TASK: speeding
*/

import java.io.*;
import java.util.*;

public class lostcow {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("lostcow.in"));
        PrintWriter out = new PrintWriter(new File("lostcow.out"));
        int farmer = br.nextInt();
        int cow = br.nextInt();
        int ans = 0;
        if(farmer-cow > 0) {
            int dir = 1;
            int diff = 1;
            while(true) {
                int pos = farmer + diff*dir;
                if(pos <= cow) {
                    ans += farmer-cow;
                    break;
                }
                else ans += 2*diff;
                diff = diff << 1;
                dir *= -1;
            }
        } else if(farmer-cow < 0) {
            int dir = 1;
            int diff = 1;
            while(true) {
                int pos = farmer + diff*dir;
                if(pos >= cow) {
                    ans += cow-farmer;
                    break;
                }
                else ans += 2*diff;
                diff = diff << 1;
                dir *= -1;
            }
        } 
        out.println(ans);
        out.close();
    }
}