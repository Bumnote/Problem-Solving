import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, s, cnt = 0, total = 0;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(lst, total);
        System.out.println(cnt);
    }

    private static void bt(ArrayList<Integer> lst, int total) {

        // 크기가 양수이면서, 부분 수열의 합이 s인 경우 -> cnt++a
        if (!lst.isEmpty() && total == s)
            cnt++;

        for (int i = 0; i < n; i++) {
            if (!lst.isEmpty() && lst.get(lst.size() - 1) >= i)
                continue;

            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                bt(lst, total + arr[i]);
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }
    }
}
