import java.util.*;
import java.io.*;

class Main {

    static class Work {
        int t;
        int s;

        public Work(int t, int s) {
            this.t = t;
            this.s = s;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, time;
    static PriorityQueue<Work> pq = new PriorityQueue<>((a, b) -> b.s - a.s);

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Work last = pq.poll();
        time = last.s - last.t;

        while (!pq.isEmpty()) {
            Work curr = pq.poll();

            time = Math.min(time, curr.s) - curr.t;
        }

        System.out.println(time < 0 ? -1 : time);
    }
}