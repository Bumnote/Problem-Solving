import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, power = 100, happiness = 0, ans = 0;
    static boolean[] visited;
    static ArrayList<Integer> lst = new ArrayList<>();
    static int[] L;
    static int[] J;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine()); // N: 사람 수

        L = new int[N];
        J = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            L[i] = Integer.parseInt(st.nextToken()); // 잃는 체력

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++)
            J[j] = Integer.parseInt(st.nextToken()); // 얻는 기쁨

        visited = new boolean[N];
        bt(lst, 0);

        System.out.println(ans);

    }

    private static void bt(ArrayList<Integer> lst, int total) {

        ans = Math.max(ans, total);

        for (int i = 0; i < N; i++) {
            if (!lst.isEmpty() && lst.get(lst.size() - 1) >= i)
                continue;

            if (!visited[i] && power - L[i] > 0) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                power -= L[i];
                bt(lst, total + J[i]);
                power += L[i];
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }
    }
}