import java.io.*;
import java.util.*;

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

    final Set<Character> set = new HashSet<>();
    set.add(' ');
    for (String word : words) {
      String[] ws = word.split(" ");
      boolean flag = false;
      int idx = -1;
      // 각 문자의 첫 글자만 우선 체크
      for (int i = 0; i < ws.length; i++) {
        String w = ws[i];
        char ch = Character.toLowerCase(w.charAt(0));
        // 문자의 첫 글자가 이미 존재하는 경우 -> continue
        if (set.contains(ch)) {
          continue;
        }
        set.add(ch);
        idx = i;
        flag = true;
        break;
      }
      // 단어의 첫 글자가 단축키로 사용되는 경우 -> 괄호 포함하여 sb 추가
      if (flag) {
        for (int i = 0; i < ws.length; i++) {
          String w = ws[i];
          if (i == idx) {
            for (int j = 0; j < w.length(); j++) {
              char ch = w.charAt(j);
              if (j == 0) {
                sb.append("[").append(ch).append("]");
              } else {
                sb.append(ch);
              }
            }
            sb.append(" ");
          } else {
            sb.append(w).append(" ");
          }
        }
        sb.append("\n");
      }
      // 단어의 첫 글자가 모두 이미 사용된 경우
      else {
        String tmp = "";
        flag = false;
        for (int i = 0; i < word.length(); i++) {
          char ch = Character.toLowerCase(word.charAt(i));
          // 해당 단어가 이미 사용된 경우 -> continue
          if (set.contains(ch)) {
            tmp = tmp.concat(String.valueOf(word.charAt(i)));
            continue;
          }

          set.add(ch);
          sb.append(tmp).append("[").append(word.charAt(i)).append("]")
              .append(word.substring(i + 1))
              .append("\n");
          flag = true;
          break;
        }

        if (!flag) {
          sb.append(tmp).append("\n");
        }
      }
    }

    System.out.print(sb);
  }
}