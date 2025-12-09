import java.io.*;
import java.util.*;

class Main {

  static class Fireball {

    int r, c, m, s, d;

    Fireball(int r, int c, int m, int s, int d) {
      this.r = r;
      this.c = c;
      this.m = m;
      this.s = s;
      this.d = d;
    }
  }

  static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
  static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

  static int n, m, k;
  static List<List<List<Fireball>>> map;
  static Deque<Fireball> dq = new ArrayDeque<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      map.add(new ArrayList<>());
      for (int j = 0; j < n; j++) {
        map.get(i).add(new ArrayList<>());
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int mm = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      Fireball fb = new Fireball(r, c, mm, s, d);
      dq.offer(fb);
      map.get(r).get(c).add(fb);
    }
  }

  private static void solve() {

    while (k-- > 0) {

      // 1. map 초기화
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          map.get(i).get(j).clear();
        }
      }

      // 2. 이동
      int size = dq.size();
      while (size-- > 0) {
        Fireball fb = dq.poll();

        int nr = (fb.r + dr[fb.d] * fb.s % n + n) % n;
        int nc = (fb.c + dc[fb.d] * fb.s % n + n) % n;

        fb.r = nr;
        fb.c = nc;

        map.get(nr).get(nc).add(fb);
      }

      // 3. 결합
      Deque<Fireball> next = new ArrayDeque<>();

      for (int r = 0; r < n; r++) {
        for (int c = 0; c < n; c++) {
          int cnt = map.get(r).get(c).size();

          if (cnt == 0) {
            continue;
          }

          if (cnt == 1) {
            next.offer(map.get(r).get(c).get(0));
            continue;
          }

          int sumM = 0, sumS = 0;
          boolean even = true, odd = true;

          for (Fireball fb : map.get(r).get(c)) {
            sumM += fb.m;
            sumS += fb.s;
            if (fb.d % 2 == 0) {
              odd = false;
            } else {
              even = false;
            }
          }

          int nm = sumM / 5;
          if (nm == 0) {
            continue; // 소멸
          }

          int ns = sumS / cnt;
          int[] nd = (even || odd) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};

          for (int d : nd) {
            next.offer(new Fireball(r, c, nm, ns, d));
          }
        }
      }

      dq = next;
    }

    System.out.print(totalMass());
  }

  private static int totalMass() {
    int sum = 0;
    for (Fireball fb : dq) {
      sum += fb.m;
    }
    return sum;
  }
}
