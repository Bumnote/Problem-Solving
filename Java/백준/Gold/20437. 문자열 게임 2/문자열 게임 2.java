import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static final int INF = 987_654_321;
  private static int t, k, shortestLength, longestLength;
  private static String w;


  public static void main(String[] args) throws IOException {
    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    System.out.print(sb);
    br.close();
    sb.setLength(0);
  }

  private static void init() throws IOException {
    w = br.readLine(); // w: 알파벳 소문자로 이루어진 문자열
    k = Integer.parseInt(br.readLine()); // k: 양의 정수
  }

  private static void solve() {

    findShortestAndLongestSubstring();

    if (shortestLength == INF || longestLength == -1) {
      sb.append(-1).append("\n");
      return;
    }

    sb.append(shortestLength).append(" ").append(longestLength).append("\n");
  }

  private static void findShortestAndLongestSubstring() {

    shortestLength = INF;
    longestLength = -1;

    Map<Character, Integer> wordMap = new HashMap<>();
    for (Character ch : w.toCharArray()) {
      wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
      // 해당 문자가 k번 이상 등장하지 않는다면 -> continue
      if (entry.getValue() < k) {
        continue;
      }

      Character ch = entry.getKey();
      int startIndex = 0;
      int targetCharacterCount = 0;
      for (int i = 0; i < w.length(); i++) {
        if (w.charAt(i) == ch) {
          targetCharacterCount++;
        }

        // 해당 문자가 k번 등장한 경우 -> 로직 구현
        if (targetCharacterCount == k) {
          while (true) {
            if (w.charAt(startIndex) == ch) {
              shortestLength = Math.min(shortestLength, i - startIndex + 1);
              longestLength = Math.max(longestLength, i - startIndex + 1);
              targetCharacterCount--;
              startIndex++;
              break;
            }
            startIndex++;
          }
        }
      }
    }
  }
}