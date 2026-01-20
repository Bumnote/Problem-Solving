import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, d, w;

  private static final PriorityQueue<int[]> score = new PriorityQueue<>((a, b) -> {
    // 점수가 같다면, 마감 기한을 기준으로 오름차순 정렬
    if (a[1] == b[1]) {
      return a[0] - b[0];
    }
    // 점수를 기준으로 오름차순 정렬
    return a[1] - b[1];
  });
  private static final PriorityQueue<int[]> data = new PriorityQueue<>((a, b) -> {
    // 마감 기한이 같다면, 점수를 기준으로 내림차순 정렬
    if (a[0] == b[0]) {
      return b[1] - a[1];
    }
    // 마감 기한을 기준으로 오름차순 정렬
    return a[0] - b[0];
  });
  private static final Set<Integer> deadlines = new TreeSet<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      data.offer(new int[]{d, w});
      deadlines.add(d);
    }

    br.close();
  }

  private static void solve() {
    for (int deadline : deadlines) {
      while (!data.isEmpty() && data.peek()[0] <= deadline) {
        score.offer(data.poll());
      }

      while (!score.isEmpty() && score.size() > deadline) {
        score.poll();
      }
    }

    int totalScore = 0;
    while (!score.isEmpty()) {
      totalScore += score.poll()[1];
    }
    System.out.print(totalScore);
  }
}
