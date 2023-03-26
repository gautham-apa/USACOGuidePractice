/*
ID: gautham15
LANG: JAVA
TASK: censor
*/

import java.io.*;
import java.util.*;

public class censor {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("censor.in"));
        PrintWriter out = new PrintWriter(new File("censor.out"));
        char[] sent = br.next().toCharArray();
        char[] str = br.next().toCharArray();
        char[] arr = new char[sent.length];
        int pos = 0;
        for(int i=0; i<sent.length; i++) {
            arr[pos++] = sent[i];
            pos = findStart(arr, str, pos);
        }
        out.println(String.valueOf(arr).substring(0, pos));
        out.close();
    }

    private static int findStart(char[] arr, char[] str, int pos) {
        int start = pos-str.length;
        if(start < 0) return pos;
        for(int i=start; i<pos; i++) {
            if(arr[i] != str[i-start]) return pos;
        }
        return start;
    }
}