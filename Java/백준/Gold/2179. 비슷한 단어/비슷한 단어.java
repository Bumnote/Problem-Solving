import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static String[] words;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }
    br.close();
  }

  private static void solve() {
    int maxLength = 0;
    String str1 = "";
    String str2 = "";
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int commonPrefixLength = calculateCommonPrefixLength(words[i], words[j]);
        if (maxLength < commonPrefixLength) {
          maxLength = commonPrefixLength;
          str1 = words[i];
          str2 = words[j];
        }
      }
    }

    System.out.println(str1);
    System.out.print(str2);
  }

  private static int calculateCommonPrefixLength(String word1, String word2) {
    int commonPrefixLength = 0;
    int len = Math.min(word1.length(), word2.length());
    for (int i = 0; i < len; i++) {
      if (word1.charAt(i) != word2.charAt(i)) {
        break;
      }
      commonPrefixLength++;
    }

    return commonPrefixLength;
  }
}