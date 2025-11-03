import java.io.*;
import java.util.*;

class Main {

  static class Country implements Comparable<Country> {

    int order;
    int id;
    int gold;
    int silver;
    int bronze;

    @Override
    public int compareTo(Country o) {
      if (this.gold != o.gold) {
        return o.gold - this.gold;
      }
      if (this.silver != o.silver) {
        return o.silver - this.silver;
      }
      if (this.bronze != o.bronze) {
        return o.bronze - this.bronze;
      }
      return 0;
    }

    public Country(int id, int gold, int silver, int bronze) {
      this.order = 1;
      this.id = id;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    public boolean isEqual(Country o) {
      return this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, k;
  private static final PriorityQueue<Country> pq = new PriorityQueue<>();


  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());
      pq.offer(new Country(id, gold, silver, bronze));
    }

    br.close();
  }

  private static void solve() {

    int answer = 0;
    int count = 0;
    Country prev = null;
    for (int i = 1; i <= k; i++) {
      Country curr = pq.poll();
      count++;
      // 초기 설정
      if (i == 1) {
        prev = curr;
      }
      // 초기 설정이 아닌 경우 -> 이전 국가의 메달과 비교
      else {
        // 이전 국가와 메달의 개수가 모두 동일한 경우
        if (curr.isEqual(prev)) {
          curr.order = prev.order;
        }
        // 이전 국가와 메달의 개수가 다른 경우
        else {
          curr.order = count;
        }

        prev = curr;
      }

      if (curr.id == k) {
        answer = curr.order;
        break;
      }
    }

    System.out.print(answer);
  }
}