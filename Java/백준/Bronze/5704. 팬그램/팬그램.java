import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String words;

    public static void main(String[] args) throws IOException {

        while (true) {
            words = br.readLine();
            if (words.equals("*"))
                break;

            int cnt = 0;
            boolean[] visited = new boolean[26];
            for (int i = 0; i < words.length(); i++) {
                char ch = words.charAt(i);
                if (ch == ' ')
                    continue;

                if (!visited[ch - 'a']) {
                    visited[words.charAt(i) - 'a'] = true;
                    cnt++;
                }
            }

            System.out.println(cnt == 26 ? "Y" : "N");
        }

    }
}

