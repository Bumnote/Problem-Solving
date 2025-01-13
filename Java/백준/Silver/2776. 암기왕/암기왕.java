import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N, M;
    static Set<Integer> s;


    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            s = new HashSet<>();
            for (int i = 0; i < N; i++)
                s.add(Integer.parseInt(st.nextToken()));

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (s.contains(num)) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
