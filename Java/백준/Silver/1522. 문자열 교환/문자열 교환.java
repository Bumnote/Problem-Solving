import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static String word;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    word = br.readLine();
  }

  private static void solve() {

    int aCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == 'a') {
        aCount++;
      }
    }

    int answer = Integer.MAX_VALUE;
    word = word.concat(word);
    for (int i = 0; i < word.length() - aCount; i++) {
      int bCount = 0;
      for (int j = i; j < i + aCount; j++) {
        if (word.charAt(j) == 'b') {
          bCount++;
        }
      }
      answer = Math.min(answer, bCount);
    }

    System.out.print(answer);
  }
}