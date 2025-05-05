import java.io.*;
import java.util.*;

class Main {

  static int N;
  static int[] V;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine()); // N: 행성의 수
    V = new int[N]; // V[i]: 행성 i로 이동하는 데 필요한 최소 속도
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      V[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void solve() {

    long v = V[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      // 현재 속도 v가 V[i] 이하라면 -> V[i]로 속도 갱신
      if (v <= V[i]) {
        v = V[i];
      }
      // 현재 속도 v가 V[i] 초과라면 -> v보다 크면서 가장 작은 V[i] 배수로 갱신
      else {
        long DIV = v / V[i];
        long MOD = v % V[i];

        v = MOD != 0 ? V[i] * (DIV + 1) : V[i] * DIV;
      }
    }

    System.out.print(v);
  }
}
