import java.io.*;
import java.util.*;

class Main {

  static class Item implements Comparable<Item> {

    int count;
    int money;
    List<Integer> type;

    public Item(int count, int money, List<Integer> type) {
      this.count = count;
      this.money = money;
      this.type = type;
    }

    @Override
    public int compareTo(Item o) {
      return o.money - this.money;
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int t, n, m, k;
  private static int[] type;
  private static List<Item> items;

  public static void main(String[] args) throws Exception {

    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    System.out.print(sb);
    br.close();
  }

  private static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    items = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int count = Integer.parseInt(st.nextToken());
      List<Integer> tmp = new ArrayList<>();
      for (int j = 0; j < count; j++) {
        tmp.add(Integer.parseInt(st.nextToken()));
      }
      int money = Integer.parseInt(st.nextToken());

      items.add(new Item(count, money, tmp));
    }

    type = new int[m];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      type[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void solve() {

    items.sort(Comparator.naturalOrder());
    int totalPrice = 0;
    for (Item item : items) {
      boolean canBuy = true;
      int minCount = Integer.MAX_VALUE;
      for (int t : item.type) {
        minCount = Math.min(minCount, type[t - 1]);
        if (type[t - 1] == 0) {
          canBuy = false;
          break;
        }
      }

      if (canBuy) {
        totalPrice += item.money * minCount;
        for (int t : item.type) {
          type[t - 1] -= minCount;
        }
      }
    }

    sb.append(totalPrice).append("\n");
  }
}