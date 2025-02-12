import java.io.*;
import java.util.*;

class Main {

    static int k, maxW, maxH;
    static int[] d = new int[6], l = new int[6], c = new int[5];

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        int wideArea = maxH * maxW; // 가장 큰 외곽 직사각형 넓이
        int narrowArea = 1; // 포함되지 않는 직사각형 넓이

        for (int i = 0; i < 6; i++) {
            if (c[d[i]] != 1) continue;
            narrowArea *= l[i + 3 > 5 ? i - 3 : i + 3];
        }

        // 출력 부분
        System.out.println((wideArea - narrowArea) * k);
    }

    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine()); // k: 참외의 개수
        maxW = 0;
        maxH = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken()); // d: 방향(1-동, 2-서, 3-남, 4-북)
            l[i] = Integer.parseInt(st.nextToken()); // l: 길이
            c[d[i]] += 1;
            // 세로 정보
            if (d[i] == 3 || d[i] == 4) maxH = Math.max(maxH, l[i]);
                // 가로 정보
            else maxW = Math.max(maxW, l[i]);
        }

        br.close();
    }
}