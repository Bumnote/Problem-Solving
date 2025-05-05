import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int m;
  static String line;
  static Map<Character, Integer> words;

  public static void main(String[] args) throws IOException {

    while (true) {
      m = Integer.parseInt(br.readLine());
      // 종료 조건
      if (m == 0) {
        break;
      }
      init();
      solve();
    }

    // 정답 출력
    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {
    line = br.readLine();
    words = new HashMap<>();
  }

  private static void solve() {

    int cnt = 0;
    int MAX = 0;
    int left = 0;
    for (int right = 0; right < line.length(); right++) {
      char c = line.charAt(right);
      // 서로 다른 문자의 개수가 m개 미만인 경우 -> 해당 문자를 추가한다.
      if (words.size() < m) {
        words.put(c, words.getOrDefault(c, 0) + 1);
        cnt++;
      }
      // 서로 다른 문자의 개수가 m 이상인 경우 -> 경우를 따져야 한다.
      else {
        // 현재 문자를 이미 가지고 있는 경우 -> 추가할 수 있다.
        if (words.containsKey(c)) {
          words.put(c, words.get(c) + 1);
          cnt++;
        }
        // 현재 문자를 가지고 있지 않은 경우 -> left 인덱스의 문자를 지워야 한다.
        else {
          words.put(c, 1);
          cnt++;
          // 문자의 개수가 여러 개 있는 경우를 생각해서 while 반복문 활용
          while (words.size() > m) {
            // left 위치의 개수를 하나 줄인다. -> 만약 0개가 된다면, 제거한다.
            char leftCh = line.charAt(left);
            words.put(leftCh, words.get(leftCh) - 1);
            cnt--;
            if (words.get(leftCh) == 0) {
              words.remove(leftCh);
            }
            left++;
          }
        }
      }

      MAX = Math.max(MAX, cnt); // 최댓값 갱신
    }

    sb.append(MAX).append("\n");
  }
}