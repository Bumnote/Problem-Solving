import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, n, m, a, b;
  private static int[] arr, inDegree;
  private static Map<Integer, Set<Integer>> teamMap;

  public static void main(String[] args) throws Exception {
    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    br.close();
    System.out.print(sb);
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    inDegree = new int[n + 1];
    teamMap = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      teamMap.put(arr[i], new HashSet<>());
      for (int j = i + 1; j <= n; j++) {
        teamMap.get(arr[i]).add(arr[j]);
        inDegree[arr[j]]++;
      }
    }

    m = Integer.parseInt(br.readLine());
    if (m > 0) {
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        // a와 b의 상대적 순서를 바꾼다.
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (teamMap.get(a).contains(b)) {
          teamMap.get(a).remove(Integer.valueOf(b));
          teamMap.get(b).add(a);
          inDegree[a]++;
          inDegree[b]--;
        } else {
          teamMap.get(b).remove(Integer.valueOf(a));
          teamMap.get(a).add(b);
          inDegree[a]--;
          inDegree[b]++;
        }
      }
    }
  }

  public static void solve() {

    Deque<Integer> dq = new ArrayDeque<>();
    List<Integer> answer = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (inDegree[arr[i]] == 0) {
        dq.offer(arr[i]);
        answer.add(arr[i]);
      }
    }

    // 확실한 순위를 찾을 수 없는 경우 -> ?
    if (dq.size() > 1) {
      sb.append("?").append("\n");
      return;
    }

    while (!dq.isEmpty()) {
      Integer curr = dq.poll();

      for (Integer nxt : teamMap.get(curr)) {
        inDegree[nxt]--;
        if (inDegree[nxt] == 0) {
          dq.offer(nxt);
          answer.add(nxt);
        }
      }
    }

    // 모든 팀의 순위를 정할 수 없는 경우(Cycle) -> IMPOSSIBLE
    if (answer.size() != n) {
      sb.append("IMPOSSIBLE").append("\n");
    } else {
      for (int team : answer) {
        sb.append(team).append(" ");
      }
      sb.append("\n");
    }
  }
}
