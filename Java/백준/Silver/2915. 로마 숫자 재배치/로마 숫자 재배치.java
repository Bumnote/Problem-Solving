import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n, answer;
  private static String romaNum;
  private static boolean[] visited;
  private static final Map<Integer, String> romaNumberMap = new HashMap<>();

  public static void main(String[] args) throws Exception {
    init();
    solve();
  }

  private static void init() throws Exception {
    romaNum = br.readLine();
    n = romaNum.length();
    visited = new boolean[n];
    mapInit();
    br.close();
  }

  private static void solve() {

    int result = -1;
    // 1의 자리인 경우
    for (int i = 1; i <= 9; i++) {
      if (romaNum.equals(romaNumberMap.get(i))) {
        result = i == 6 ? 4 : i;
        break;
      }
    }

    if (result != -1) {
      System.out.print(romaNumberMap.get(result));
      return;
    }

    // 10의 자리인 경우
    answer = 100;
    bt(0, "");
    if (answer == 11) {
      System.out.println("IX");
    } else {
      System.out.print(romaNumberMap.get((answer / 10) * 10) + romaNumberMap.get(answer % 10));
    }
  }


  private static void mapInit() {
    romaNumberMap.put(1, "I");
    romaNumberMap.put(2, "II");
    romaNumberMap.put(3, "III");
    romaNumberMap.put(4, "IV");
    romaNumberMap.put(5, "V");
    romaNumberMap.put(6, "VI");
    romaNumberMap.put(7, "VII");
    romaNumberMap.put(8, "VIII");
    romaNumberMap.put(9, "IX");

    romaNumberMap.put(10, "X");
    romaNumberMap.put(20, "XX");
    romaNumberMap.put(30, "XXX");
    romaNumberMap.put(40, "XL");
    romaNumberMap.put(50, "L");
    romaNumberMap.put(60, "LX");
    romaNumberMap.put(70, "LXX");
    romaNumberMap.put(80, "LXXX");
    romaNumberMap.put(90, "XC");
  }

  private static void bt(int cnt, String tmpStr) {
    if (cnt == n) {
      int minNum = 100;
      for (int idx = 0; idx < n; idx++) {
        String prefix = tmpStr.substring(0, idx + 1);
        String suffix = tmpStr.substring(idx + 1);

        if (romaNumberMap.containsValue(prefix) && romaNumberMap.containsValue(suffix)) {
          int prefixNum = 0;
          int suffixNum = 0;

          for (Map.Entry<Integer, String> entry : romaNumberMap.entrySet()) {
            if (entry.getValue().equals(prefix)) {
              prefixNum = entry.getKey();
            }
            if (entry.getValue().equals(suffix)) {
              suffixNum = entry.getKey();
            }
          }

          if (prefixNum >= 10 && suffixNum < 10) {
            minNum = Math.min(minNum, prefixNum + suffixNum);
          }
        }
      }

      answer = Math.min(answer, minNum);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        String nxtRomaNum = tmpStr + romaNum.charAt(i);
        bt(cnt + 1, nxtRomaNum);
        visited[i] = false;
      }
    }
  }
}