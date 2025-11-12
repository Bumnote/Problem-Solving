import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  // n: 빌딩의 층 수 (1 <= n <= 999_999)
  // k: 자릿 수
  // p: 최대 반전 횟수 (최소: 1개)
  // x: 현재 층 수
  private static String strX;
  private static int n, k, p, x;
  private static final String ZERO = "0";
  private static final Map<Integer, Integer> bitmap = new HashMap<>();

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    p = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    bitmapInit();
    strX = String.valueOf(x);
    while (strX.length() < k) {
      strX = ZERO.concat(strX);
    }
    br.close();
  }

  private static void solve() {

    int answer = 0;
    for (int num = 1; num <= n; num++) {
      int bitCount = calculateBitCount(num);
      if (1 <= bitCount && bitCount <= p) {
        answer++;
      }
    }

    System.out.print(answer);
  }

  private static void bitmapInit() {
    bitmap.put(0, 126);
    bitmap.put(1, 24);
    bitmap.put(2, 55);
    bitmap.put(3, 61);
    bitmap.put(4, 89);
    bitmap.put(5, 109);
    bitmap.put(6, 111);
    bitmap.put(7, 56);
    bitmap.put(8, 127);
    bitmap.put(9, 125);
  }

  private static int calculateBitCount(int num) {

    String strNum = String.valueOf(num);
    while (strNum.length() < k) {
      strNum = ZERO.concat(strNum);
    }

    int totalBitCount = 0;
    for (int i = 0; i < k; i++) {
      int target = bitmap.get(strNum.charAt(i) - '0');
      int curr = bitmap.get(strX.charAt(i) - '0');
      totalBitCount += Integer.bitCount(curr ^ target);
    }

    return totalBitCount;
  }
}