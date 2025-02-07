import java.io.*;
import java.util.*;

public class Main {

    static class DNA implements Comparable<DNA> {
        char d;
        int c;

        DNA(char d, int c) {
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(DNA o) {
            if (this.c != o.c)
                return this.c - o.c; // 개수 기준으로 오름차순 정렬
            return o.d - this.d; // 사전순으로 내림차순 정렬
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, cnt, a, c, g, t;
    static String line;
    static char[][] map;
    static ArrayList<DNA> lst;


    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        cnt = 0;
        // 열우선 탐색
        for (int x = 0; x < M; x++) {
            a = 0;
            c = 0;
            g = 0;
            t = 0;
            for (int y = 0; y < N; y++) {
                if (map[y][x] == 'A') a++;
                else if (map[y][x] == 'C') c++;
                else if (map[y][x] == 'G') g++;
                else t++;
            }
            lst = new ArrayList<>();
            if (a > 0)
                lst.add(new DNA('A', a));
            if (c > 0)
                lst.add(new DNA('C', c));
            if (g > 0)
                lst.add(new DNA('G', g));
            if (t > 0)
                lst.add(new DNA('T', t));

            Collections.sort(lst); // 주어진 기준으로 정렬
            cnt += (N - lst.get(lst.size() - 1).c);  // 가장 많이 있는 알파벳와 다른 알파벳 개수 감소
            sb.append(lst.get(lst.size() - 1).d); // 가장 많은 알파벳 추가
        }

        sb.append("\n").append(cnt);
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {

        // 입력 부분
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        br.close();
    }

}
