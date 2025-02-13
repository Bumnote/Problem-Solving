import java.io.*;
import java.util.*;

class Main {

    static String line;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        boolean flag = false;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for (char ch : line.toCharArray()) {
            if (flag) {
                sb.append(ch);
                if (ch == '>')
                    flag = false;
            } else if (ch == '<') {
                while (!dq.isEmpty())
                    sb.append(dq.pollLast());
                flag = true;
                sb.append('<');
            } else if (ch != ' ') {
                dq.offer(ch);
            } else {
                while (!dq.isEmpty())
                    sb.append(dq.pollLast());
                sb.append(" ");
            }
        }
        while (!dq.isEmpty())
            sb.append(dq.pollLast());
        System.out.println(sb.toString());
    }


    private static void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();

        br.close();
    }
}
