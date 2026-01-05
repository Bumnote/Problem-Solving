import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static String word;

  public static void main(String[] args) throws Exception {
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      init();
      solve();
    }
    System.out.print(sb);
  }

  private static void init() throws Exception {
    word = br.readLine();
  }

  // 0 -> 회문
  // 1 -> 유사회문
  // 2 -> 아무것도 아님
  // 문자 하나 제거 가능

  private static void solve() {
    int start = 0;
    int end = word.length() - 1;

    boolean flag = true;
    int result = 2;
    while (start < end) {

      // 양쪽 문자가 일치하는 경우 -> 양쪽 포인터 이동
      if (word.charAt(start) == word.charAt(end)) {
        start++;
        end--;
      }
      // 양쪽 문자가 일치하지 않는 경우 -> 양쪽 문자 하나씩 제거 후 다시 비교
      else {
        flag = false;
        if (isPalindrome(start + 1, end) || isPalindrome(start, end - 1)) {
          result = 1;
        }
        break;
      }
    }

    if (flag) {
      result = 0;
    }

    sb.append(result).append("\n");
  }

  private static boolean isPalindrome(int s, int e) {
    while (s < e) {
      if (word.charAt(s) != word.charAt(e)) {
        return false;
      }
      s++;
      e--;
    }
    return true;
  }
}
