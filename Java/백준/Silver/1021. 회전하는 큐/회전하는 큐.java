import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Deque<Integer> lst = new ArrayDeque<>();
    static Deque<Integer> dq = new ArrayDeque<>();
    static int n, m, target, idx, cnt = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            lst.addLast(i);

        for (int i = 0; i < m; i++)
            dq.addLast(Integer.parseInt(st.nextToken()));

        while (!dq.isEmpty()) {

            target = dq.pollFirst();
            idx = getElementIndex(target, lst);
            if (idx == 0)
                lst.pollFirst();
            else if (lst.size() - idx >= idx) {
                for (int i = 0; i < idx; i++) {
                    lst.addLast(lst.pollFirst());
                    cnt++;
                }
                lst.pollFirst();
            } else {
                for (int i = 0; i < lst.size() - idx; i++) {
                    lst.addFirst(lst.pollLast());
                    cnt++;
                }
                lst.pollFirst();
            }
        }

        System.out.println(cnt);

    }

    private static int getElementIndex(int target, Deque<Integer> dq) {

        int idx = 0;
        for (Integer value : dq) {
            if (value == target)
                return idx;
            idx++;
        }

        return -1;
    }
}