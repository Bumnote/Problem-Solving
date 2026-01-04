import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static final PriorityQueue<Integer> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      pq.offer(Integer.parseInt(br.readLine()));
    }
    br.close();
  }

  private static void solve() throws IOException {
    int count = 0;
    while (pq.size() >= 2) {
      int A = pq.poll();
      int B = pq.poll();
      int sum = A + B;
      count += sum;
      pq.offer(sum);
    }

    System.out.print(count);
  }
}
