import java.io.*;
import java.util.*;

class Main {

    static int w, h, p, q, t;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {

        q = (q + t) % (2 * h);
        p = (p + t) % (2 * w);

        if (q > h) q = 2 * h - q;
        if (p > w) p = 2 * w - p;

        System.out.printf("%d %d\n", p, q);
    }


    private static void init() throws IOException {

        // 입력 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); // w: 가로
        h = Integer.parseInt(st.nextToken()); // h: 세로

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); // p: 초기 위치 x
        q = Integer.parseInt(st.nextToken()); // q: 초기 위치 y

        t = Integer.parseInt(br.readLine()); // t: 개미가 움직일 시간

        br.close();
    }
}