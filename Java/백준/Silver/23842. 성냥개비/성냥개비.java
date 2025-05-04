import java.io.*;
import java.util.*;

class Main {

  static int N;
  static Map<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    mapInit();

    br.close();
  }

  private static void solve() {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 99; i++) {
      for (int j = 0; j < 99; j++) {
        // 두 자리가 넘는 경우 -> 내부 for문 break;
        if (i + j >= 100) {
          break;
        }

        int cnt = getMatchCnt(i, j, i + j);
        // + 와 = 는 빼고 생각한다.
        if (cnt == N - 4) {
          sb.append(String.format("%02d+%02d=%02d", i, j, i + j));
          System.out.print(sb);
          return;
        }
      }
    }

    System.out.print("impossible");
  }

  private static int getMatchCnt(int a, int b, int c) {

    int total = 0;
    // 한 자릿수 인 경우 -> 전처리
    if (a < 10) {
      total += map.get(0);
      if (a == 0) {
        total += map.get(0);
      }
    }
    if (b < 10) {
      total += map.get(0);
      if (b == 0) {
        total += map.get(0);
      }
    }
    if (c < 10) {
      total += map.get(0);
      if (c == 0) {
        total += map.get(0);
      }
    }

    while (a > 0) {
      int num = a % 10;
      total += map.get(num);
      a /= 10;
    }

    while (b > 0) {
      int num = b % 10;
      total += map.get(num);
      b /= 10;
    }

    while (c > 0) {
      int num = c % 10;
      total += map.get(num);
      c /= 10;
    }

    return total;
  }

  private static void mapInit() {
    map = new HashMap<>();
    map.put(0, 6);
    map.put(1, 2);
    map.put(2, 5);
    map.put(3, 5);
    map.put(4, 4);
    map.put(5, 5);
    map.put(6, 6);
    map.put(7, 3);
    map.put(8, 7);
    map.put(9, 6);
  }
}