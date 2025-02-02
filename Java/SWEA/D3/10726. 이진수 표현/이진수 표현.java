import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int T, N, M;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            // M의 이진수 표현의 마지막 N 비트가 모두 1인지?
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int flag = (~(1 << 31)) >> (32 - N - 1);

            if ((M & flag) == Math.pow(2, N) - 1) bw.write(String.format("#%d %s\n", tc, "ON"));
            else bw.write(String.format("#%d %s\n", tc, "OFF"));

        }

        br.close();
        bw.close();
    }
}

