import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int g, p;
  private static int[] parent;
  private static int[] planes;

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {

    g = Integer.parseInt(br.readLine()); // g: 게이트 수
    p = Integer.parseInt(br.readLine()); // p: 비행기 수

    planes = new int[p];
    for (int i = 0; i < p; i++) {
      planes[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void solve() {

    parent = new int[g + 1];
    for (int i = 1; i <= g; i++) {
      parent[i] = i;
    }

    int count = 0;
    for (int plane : planes) {
      int currGate = find(plane);
      if (currGate == 0) {
        break;
      }

      union(plane, currGate - 1);
      count++;
    }

    System.out.print(count);
  }

  private static void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot == yRoot) {
      return;
    }

    if (xRoot > yRoot) {
      int tmp = xRoot;
      xRoot = yRoot;
      yRoot = tmp;
    }

    parent[yRoot] = xRoot;
  }

  private static int find(int x) {
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
}