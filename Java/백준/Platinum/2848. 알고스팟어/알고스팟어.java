import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static String[] word;
  private static final Map<Character, Integer> inDegree = new HashMap<>();
  private static final Map<Character, Set<Character>> graph = new HashMap<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    n = Integer.parseInt(br.readLine());
    word = new String[n];
    for (int i = 0; i < n; i++) {
      word[i] = br.readLine();
      for (char ch : word[i].toCharArray()) {
        inDegree.put(ch, 0);
        graph.putIfAbsent(ch, new HashSet<>());
      }
    }

    br.close();
  }

  private static void solve() {

    // 상대적 순서를 구한다.
    for (int i = 1; i < n; i++) {
      boolean isFalse = findDiffAlpha(word[i - 1], word[i]);
      if (isFalse) {
        System.out.print("!");
        return;
      }
    }

    Deque<Character> dq = new ArrayDeque<>();
    List<Character> path = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        dq.offer(entry.getKey());
      }
    }

    boolean ambiguous = false;
    while (!dq.isEmpty()) {
      if (dq.size() > 1) {
        ambiguous = true;
      }

      char curr = dq.poll();
      path.add(curr);

      for (char nxt : graph.get(curr)) {
        inDegree.put(nxt, inDegree.get(nxt) - 1);
        if (inDegree.get(nxt) == 0) {
          dq.offer(nxt);
        }
      }
    }

    for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
      // 싸이클이 발생하여 올바른 순서가 없는 경우 -> ! 출력
      if (entry.getValue() != 0) {
        System.out.print("!");
        return;
      }
    }
    
    if (ambiguous) {
      System.out.print("?");
      return;
    }

    for (char ch : path) {
      sb.append(ch);
    }

    System.out.print(sb);
  }

  private static boolean findDiffAlpha(String word, String target) {

    int shortLen = Math.min(word.length(), target.length());

    for (int i = 0; i < shortLen; i++) {
      // word[i] -> word[j]
      if (word.charAt(i) != target.charAt(i)) {
        if (graph.get(word.charAt(i)).add(target.charAt(i))) {
          inDegree.put(target.charAt(i), inDegree.get(target.charAt(i)) + 1);
        }
        return false;
      }
    }

    // 접두사 관계인데 길이가 더 긴 경우 -> ! 출력
    return word.length() > target.length();
  }
}