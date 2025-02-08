import java.io.*;
import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int L, R, SUM, MUL, ANS, res, tmp, nxt, flag, MAX = 100_000;
    static boolean[] visited;

    public static void main(String[] args) {


        init();

        solve();

    }

    private static void solve() {

        for (int i = L; i <= R; i++) {
            visited = new boolean[MAX + 1];
            visited[i] = true; // 시작점 방문 처리

            flag = 0;
            dfs(i);
            ANS += flag;
        }

        System.out.println(ANS);
    }

    private static void dfs(int curr) {

        tmp = curr;
        SUM = 0;
        MUL = 1;
        while (tmp > 0) {
            res = tmp % 10;
            SUM += (res);
            MUL *= (res);

            tmp /= 10;
        }

        sb.append(SUM).append(MUL);
        nxt = Integer.parseInt(sb.toString());
        sb.setLength(0);
        // 범위를 넘지 않는 경우 -> 탐색 가능
        if (inRange(nxt)) {
            // 방문이 가능한 경우, 즉, 처음 만난 숫자의 경우 -> 탐색 가능
            if (!visited[nxt]) {
                visited[nxt] = true; // 방문 처리
                dfs(nxt);
            }
            // 방문은 했지만, 그게 자기 자신인 경우 -> 1 반환
            else if (curr == nxt)
                flag = 1;
                // 방문은 했지만, 그게 자기 자신이 아닌 경우 -> 사이클이 발생하므로, 0 반환
            else
                flag = 0;

        } else
            flag = -1;

        return;
    }

    private static boolean inRange(int num) {
        return 1 <= num && num <= MAX;
    }


    private static void init() {

        L = sc.nextInt();
        R = sc.nextInt();

    }

}
