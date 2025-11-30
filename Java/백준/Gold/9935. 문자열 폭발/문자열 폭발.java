import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String str; // 1 ≤ length ≤ 1_000_000
  private static String targetStr; // 1 ≤ length ≤ 36

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    str = br.readLine();
    targetStr = br.readLine();
    br.close();
  }

  private static void solve() {
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      stk.push(str.charAt(i));

      if (stk.size() >= targetStr.length()) {
        // 같은 문자열이 존재하지 않는다면 -> 복원
        if (isSameWord(stk)) {
          for (int j = 0; j < targetStr.length(); j++) {
            stk.pop();
          }
        }
      }
    }

    for (char c : stk) {
      sb.append(c);
    }

    System.out.print(sb.length() == 0 ? "FRULA" : sb.toString());
  }

  private static boolean isSameWord(Stack<Character> stk) {
    for (int i = 0; i < targetStr.length(); i++) {
      if (stk.get(stk.size() - targetStr.length() + i) != targetStr.charAt(i)) {
        return false;
      }
    }

    return true;
  }
}
