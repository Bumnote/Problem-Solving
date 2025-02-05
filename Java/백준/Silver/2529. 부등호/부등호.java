import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int k;
    static long MAX, MIN;
    static char[] arr;
    static ArrayList<Integer> lst;
    static boolean[] visited;
    static String str, SMAX, SMIN;

    public static void main(String[] args) throws IOException {

        input();

        solve();

    }

    private static void solve() {

        MAX = -1;
        MIN = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            lst = new ArrayList<>();

            lst.add(i);
            visited[i] = true; // 시작점 방문 처리
            bt(1, lst);
            visited[i] = false; // 시작점 복원 처리
        }

        System.out.println(SMAX);
        System.out.println(SMIN);

    }

    private static void bt(int cnt, ArrayList<Integer> lst) {

        // k + 1 개의 숫자를 모두 채웠다면 -> 저장
        if (cnt == k + 1) {

            for (Integer num : lst)
                sb.append(num);

            str = sb.toString();
            if (MAX < Long.parseLong(str)) {
                MAX = Long.parseLong(str);
                SMAX = str;
            }

            if (MIN > Long.parseLong(str)) {
                MIN = Long.parseLong(str);
                SMIN = str;
            }

            sb.setLength(0); // 초기화
            return;
        }

        for (int i = 0; i < 10; i++) {

            if (arr[cnt - 1] == '<' && lst.get(lst.size() - 1) > i)
                continue;
            if (arr[cnt - 1] == '>' && lst.get(lst.size() - 1) < i)
                continue;

            // 방문한 적이 없는 경우 -> 탐색
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                bt(cnt + 1, lst);
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }

    }

    private static void input() throws IOException {

        // 입력 부분
        k = Integer.parseInt(br.readLine());
        visited = new boolean[10];

        arr = new char[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++)
            arr[i] = st.nextToken().charAt(0);

        br.close();
    }
}
