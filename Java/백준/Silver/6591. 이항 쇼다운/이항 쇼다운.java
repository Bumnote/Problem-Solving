import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int n, k;

  public static void main(String[] args) throws IOException {

    while (true) {
      // 입력 부분
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      if (n == 0 && k == 0) {
        break;
      }
      solve();
    }
    // 정답 출력 및 입력 버퍼 close
    System.out.print(sb);
    br.close();
  }

  private static void solve() {
    // n개의 원소 중에서 k개를 순서 없이 선택하는 방법의 수
    long ans = 1;
    if (n == k || k == 0) sb.append(1).append("\n");
    else {
      if (n - k < k) k = n - k;
      for (int i = 0; i < k; i++) {
        ans *= n--;
        ans /= (i + 1);
      }
      sb.append(ans).append("\n");
    }
  }
}
