import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int N, E, C;
  static ArrayList<Set<Integer>> song;
  static Set<Integer> K;

  public static void main(String[] args) throws IOException {
    init();
    solve();

    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {
    // 선영 = 1
    N = Integer.parseInt(br.readLine()); // N: 사람의 수
    E = Integer.parseInt(br.readLine()); // E: 날짜의 수
  }

  private static void solve() throws IOException {

    // 각 요소마다 Set 저장
    song = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      song.add(new HashSet<>());
    }

    for (int i = 1; i <= E; i++) {
      st = new StringTokenizer(br.readLine());
      C = Integer.parseInt(st.nextToken()); // C: E일 참가한 사람의 수
      K = new HashSet<>();
      for (int j = 0; j < C; j++) {
        K.add(Integer.parseInt(st.nextToken()));
      }

      // 선영이가 참여한 경우 -> 해당 날짜에 참여한 인원들 모두 i 노래 추가
      if (K.contains(1)) {
        for (int k : K) {
          song.get(k).add(i);
        }
      }
      // 선영이가 참여하지 않은 경우 -> 가장 노래를 많이 아는 사람의 개수로 업데이트
      else {
        Set<Integer> tmp = new HashSet<>();
        for (int idx : K) {
          tmp.addAll(song.get(idx)); // 해당 날짜에 참여한 모든 인원의 아는 노래 동기화
        }

        for (int idx : K) {
          song.get(idx).addAll(tmp);
        }
      }
    }

    int allSongCnt = song.get(1).size();
    sb.append(1).append("\n");
    for (int i = 2; i <= N; i++) {
      if (allSongCnt == song.get(i).size()) {
        sb.append(i).append("\n");
      }
    }
  }
}