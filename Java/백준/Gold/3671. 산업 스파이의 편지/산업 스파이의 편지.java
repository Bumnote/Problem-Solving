import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean[] sieve;
    static boolean[] visited;
    static char[] arr;
    static int MAX = 10_000_000;
    static int c;
    static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) throws IOException {

        // 에라토스테네스의 체 구현
        sieve = new boolean[MAX];
        for (int i = 2; i <= Math.sqrt(MAX); i++)
            if (!sieve[i])
                for (int j = i * i; j < MAX; j += i)
                    sieve[j] = true;

        c = Integer.parseInt(br.readLine());

        for (int t = 0; t < c; t++) {
            arr = br.readLine().toCharArray();
            int len = arr.length;
            visited = new boolean[len];
            bt(new ArrayList<Integer>(), len);

            bw.write(s.size() + "\n");
            s.clear();
        }

        bw.close();
    }

    private static void bt(ArrayList<Integer> lst, int len) {

        if (!lst.isEmpty() && lst.size() <= len) {
            for (int idx : lst)
                sb.append(arr[idx]);

            int num = Integer.parseInt(sb.toString());
            if (num >= 2 && !sieve[num])
                s.add(num);

            sb.setLength(0);

            if (lst.size() == len) return;
        }


        for (int i = 0; i < len; i++) {
            // 방문하지 않은 숫자들에 대해서만 백트리캥 진행
            if (!visited[i]) {
                visited[i] = true; // 방문 처리
                lst.add(i);
                bt(lst, len);
                lst.remove(lst.size() - 1);
                visited[i] = false; // 복원 처리
            }
        }
    }

}

