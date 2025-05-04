import java.io.*;
import java.util.*;

class Main {

  static String line;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    line = br.readLine();
    br.close();
  }

  private static void solve() {
    // x가 존재하는 경우 -> x를 기준으로 파싱
    if (line.contains("x")) {
      int result = 0;
      for (int i = 0; i < line.length(); i++) {
        // x를 만난 경우 -> 계수를 뽑아낸다.
        if (line.charAt(i) == 'x') {
          // 그냥 x인 경우 -> 1을 더한다.
          if (i == 0) {
            result++;
          }
          // x앞이 바로 부호인 경우 -> 1 또는 -1을 더한다.
          else if (line.charAt(i - 1) == '-' || line.charAt(i - 1) == '+') {
            if (line.charAt(i - 1) == '+') {
              result++;
            } else {
              result--;
            }
          }
          // x앞이 숫자인 경우 -> 숫자를 구하여 계수와 함께 더한다.
          else {
            int idx = i - 1;
            // 범위를 넘지 않고, 숫자인 경우까지 인덱스를 낮춘다.
            while (inRange(idx) && '0' <= line.charAt(idx) && line.charAt(idx) <= '9') {
              idx--;
            }
            // 양수인 경우 -> 더한다.
            if (idx == -1 || line.charAt(idx) == '+') {
              result += Integer.parseInt(line.substring(idx + 1, i));
            }
            // 음수인 경우 -> 뺸다.
            else {
              result -= Integer.parseInt(line.substring(idx + 1, i));
            }
          }
        }
      }
      System.out.print(result);
    }
    // x가 존재하지 않는 경우 -> 미분하면 항상 0
    else {
      System.out.print(0);
    }
  }

  private static boolean inRange(int idx) {
    return 0 <= idx && idx < line.length();
  }
}