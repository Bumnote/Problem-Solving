import java.io.*;
import java.util.*;

public class Main {

  static int N;
  static PriorityQueue<Integer> pq;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    pq = new PriorityQueue<>(Comparator.reverseOrder());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        pq.offer(Integer.parseInt(st.nextToken()));
      }
    }
    br.close();
  }

  private static void solve() {

    int ans = 0;
    for (int i = 0; i < N; i++) {
      ans = pq.poll();
    }
    System.out.println(ans);
  }

}