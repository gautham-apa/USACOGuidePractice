/*
ID: gautham15
LANG: JAVA
TASK: tttt
*/

// http://www.usaco.org/index.php?page=viewproblem2&cpid=831

import java.io.*;
import java.util.*;

public class tttt {
    public static void main(String args[]) throws IOException {
        Scanner br = new Scanner(new File("tttt.in"));
        PrintWriter out = new PrintWriter(new File("tttt.out"));
        char[][] board = new char[3][3];
        for(int i=0; i<3; i++) board[i] = br.nextLine().toCharArray();
        HashSet<Character> s = new HashSet<>();
        HashSet<String> d = new HashSet<>();
        for(int i=0; i<3; i++) {
            TreeSet<Character> set = new TreeSet<>();
            for(int j=0; j<3; j++) set.add(board[i][j]);
            if(set.size() == 1) s.add(set.first());
            if(set.size() == 2) d.add(set.first()+""+set.last());
        }
        for(int i=0; i<3; i++) {
            TreeSet<Character> set = new TreeSet<>();
            for(int j=0; j<3; j++) set.add(board[j][i]);
            if(set.size() == 1) s.add(set.first());
            if(set.size() == 2) d.add(set.first()+""+set.last());
        }
        // left diagonal
        TreeSet<Character> set = new TreeSet<>();
        set.add(board[0][0]); set.add(board[1][1]); set.add(board[2][2]);
        if(set.size() == 1) s.add(set.first());
        if(set.size() == 2) d.add(set.first()+""+set.last());

        // right diagonal
        set = new TreeSet<>();
        set.add(board[0][2]); set.add(board[1][1]); set.add(board[2][0]);
        if(set.size() == 1) s.add(set.first());
        if(set.size() == 2) d.add(set.first()+""+set.last());

        out.println(s.size());
        out.println(d.size());
        out.close();
    }
}