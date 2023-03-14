/*
ID: gautham15
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.*;

public class combo {
    static Set<String> set = new HashSet<>();
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("combo.in"));
        PrintWriter out = new PrintWriter(new File("combo.out"));
        int n = br.nextInt();
        int[] farmer = new int[3];
        for(int i=0; i<3; i++) {
            farmer[i] = br.nextInt();
        }
        int[] maker = new int[3];
        for(int i=0; i<3; i++) {
            maker[i] = br.nextInt();
        }
        dfs(farmer, new int[3], 0, n);
        dfs(maker, new int[3], 0, n);
        out.println(set.size());
        out.close();
    }

    private static void dfs(int[] dig, int[] comb, int pos, int n) {
        if(pos >= 3) return;
        for(int i=-2; i<=2; i++) {
            comb[pos] = dig[pos]+i;
            if(comb[pos]<1) comb[pos] = Math.max(1, comb[pos]+n);
            else if(comb[pos]>n) comb[pos] = Math.min(comb[pos]-n, n);
            dfs(dig, comb, pos+1, n);
            if(pos == 2) compute(comb);
        }
    }

    private static void compute(int[] comb) {
        String num = comb[0]+","+comb[1]+","+comb[2];
        if(set.contains(num)) return;
        set.add(num);
    }
}