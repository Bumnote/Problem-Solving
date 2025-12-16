import java.io.*;
import java.util.*;

class Main {

  static class Word implements Comparable<Word> {

    String content;
    int length;
    int frequency;

    Word(String content, int length, int frequency) {
      this.content = content;
      this.length = length;
      this.frequency = frequency;

    }

    @Override
    public int compareTo(Word o) {
      if (this.frequency == o.frequency) {
        if (this.length == o.length) {
          return this.content.compareTo(o.content);
        }
        return Integer.compare(o.length, this.length);
      }
      return Integer.compare(o.frequency, this.frequency);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, m;
  private static final Map<String, Integer> map = new HashMap<>();
  private static final PriorityQueue<Word> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (word.length() >= m) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
    }
    br.close();
  }

  private static void solve() {

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      String word = entry.getKey();
      int frequency = entry.getValue();

      pq.offer(new Word(word, word.length(), frequency));
    }

    while (!pq.isEmpty()) {
      sb.append(pq.poll().content).append('\n');
    }

    System.out.print(sb);
  }
}
