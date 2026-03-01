import java.io.*;
import java.util.*;

class Main {

  static class Point implements Comparable<Point> {

    int x, y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      if (this.x == o.x) {
        return Integer.compare(this.y, o.y);
      }
      return Integer.compare(this.x, o.x);
    }
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static Point[] dots;
  private static int targetX, targetY;


  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    targetX = Integer.parseInt(st.nextToken());
    targetY = Integer.parseInt(st.nextToken());

    dots = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      dots[i] = new Point(x, y);
    }

    br.close();
  }

  private static void solve() {

    Arrays.sort(dots);

    int count = 0;
    for (Point dot : dots) {
      Point leftTop = new Point(dot.x, dot.y + targetY);
      Point rightBottom = new Point(dot.x + targetX, dot.y);
      Point rightTop = new Point(dot.x + targetX, dot.y + targetY);

      if (exists(leftTop) && exists(rightBottom) && exists(rightTop)) {
        count++;
      }
    }

    System.out.print(count);
  }

  private static boolean exists(Point target) {
    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int cmp = dots[mid].compareTo(target);

      if (cmp == 0) {
        return true;
      } else if (cmp > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return false;
  }
}