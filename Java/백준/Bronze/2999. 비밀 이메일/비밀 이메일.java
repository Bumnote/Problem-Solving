import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String word;

    public static void main(String[] args) throws IOException {

        word = br.readLine();
        int N = word.length();
        int r = 1, c = N;
        for (int i = N / 2; i >= 1; i--) {
            r = i;
            c = N / i;
            if (r <= c && r * c == N) {
                break;
            }
        }

        char[][] map = new char[r][c];
        int cnt = 0;
        // 채우기
        for (int i = 0; i < c; i++)
            for (int j = 0; j < r; j++) {
                map[j][i] = word.charAt(cnt++);
            }

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sb.append(map[i][j]);

        System.out.println(sb.toString());
    }
}
