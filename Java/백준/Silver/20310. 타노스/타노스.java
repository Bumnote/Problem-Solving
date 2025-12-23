import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String word;
  private static int zeroCount, oneCount, zeroHalfCount, oneHalfCount;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    word = br.readLine();
    br.close();
  }

  private static void solve() {
    countingNumberOfWord();

    for (int i = 0; i < word.length(); i++) {
      // 0은 절반 이상이면 뒤의 0을 모두 제거
      if (word.charAt(i) == '0') {
        if (--zeroCount >= zeroHalfCount) {
          sb.append('0');
        }
      }
      // 1은 절반 이상이면 앞의 1을 모두 제거
      else {
        if (--oneCount >= oneHalfCount) {
          continue;
        }
        sb.append('1');
      }
    }

    System.out.print(sb);
  }

  private static void countingNumberOfWord() {
    zeroCount = 0;
    oneCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == '0') {
        zeroCount++;
      } else {
        oneCount++;
      }
    }

    zeroHalfCount = zeroCount / 2;
    oneHalfCount = oneCount / 2;
  }
}
