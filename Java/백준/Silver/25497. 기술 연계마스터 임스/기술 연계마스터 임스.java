import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, cnt;
    static String line;
    static char c;
    static Stack<Character> lr, sk;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        // L -> R
        // S -> K

        cnt = 0;
        line = br.readLine();
        lr = new Stack<>();
        sk = new Stack<>();
        for (int i = 0; i < N; i++) {
            c = line.charAt(i);
            if (Character.isDigit(c)) cnt++;
            else if (c == 'L') lr.push(c);
            else if (c == 'S') sk.push(c);
            else if (c == 'R') {
                if (!lr.isEmpty()) {
                    lr.pop();
                    cnt++;
                } else break;
            } else if (c == 'K') {
                if (!sk.isEmpty()) {
                    sk.pop();
                    cnt++;
                } else break;
            }

        }

        br.close();
        System.out.println(cnt);
    }
}