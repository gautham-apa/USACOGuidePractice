/*
ID: gautham15
LANG: JAVA
TASK: blocks
*/

import java.io.*;
import java.util.*;

public class blocks {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("blocks.in"));
        PrintWriter out = new PrintWriter(new File("blocks.out"));
        int n = br.nextInt();
        int[] count = new int[26];
        while(n-- > 0) {
            String first = br.next();
            String second = br.next();
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            for(char c: first.toCharArray()) arr1[c-'a']++;
            for(char c: second.toCharArray()) arr2[c-'a']++;
            
            for(int i=0; i<26; i++) {
                count[i] += Math.max(arr1[i], arr2[i]);
            }
        }
        for(int i=0; i<26; i++) out.println(count[i]);
        out.close();
    }
}