import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            pq.offer(Integer.parseInt(st.nextToken()));

        int sum = 0, ans = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
            ans += sum;
        }

        System.out.println(ans);
    }
}