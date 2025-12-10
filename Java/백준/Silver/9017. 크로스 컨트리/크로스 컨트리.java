import static java.util.Arrays.fill;

import java.io.*;
import java.util.*;

class Main {


  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int[] team;
  private static final int[] scores = new int[201];
  private static final int[] count = new int[201];

  public static void main(String[] args) throws Exception {
    int t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }
    System.out.print(sb);
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    team = new int[n];
    fill(scores, 0);
    fill(count, 0);

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      team[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void solve() {

    for (int teamNum : team) {
      count[teamNum]++;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 1; i <= 200; i++) {
      if (count[i] == 6) {
        map.putIfAbsent(i, new ArrayList<>());
      }
    }

    int score = 1;
    for (int i = 0; i < n; i++) {
      int teamNum = team[i];
      if (map.containsKey(teamNum)) {
        map.get(teamNum).add(score);
        if (map.get(teamNum).size() <= 4) {
          scores[teamNum] += (score++);
        } else {
          score++;
        }
      }
    }

    int minScore = Integer.MAX_VALUE;
    List<Integer> winnerList = new ArrayList<>();

    for (int i = 1; i <= 200; i++) {
      if (scores[i] == 0) {
        continue;
      }

      if (minScore > scores[i]) {
        minScore = scores[i];
        winnerList.clear();
        winnerList.add(i);
      } else if (minScore == scores[i]) {
        winnerList.add(i);
      }
    }

    if (winnerList.size() > 1) {
      int winnerTeam = winnerList.get(0);
      int fifthMemberScore = map.get(winnerTeam).get(4);
      for (int i = 1; i < winnerList.size(); i++) {
        int teamNum = winnerList.get(i);
        if (fifthMemberScore > map.get(winnerList.get(i)).get(4)) {
          fifthMemberScore = scores[teamNum];
          winnerTeam = teamNum;
        }
      }
      sb.append(winnerTeam).append("\n");
    } else if (winnerList.size() == 1) {
      sb.append(winnerList.get(0)).append("\n");
    }
  }
}
