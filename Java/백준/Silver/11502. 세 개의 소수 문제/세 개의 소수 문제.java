import java.io.*;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;

  static int t, k;
  static boolean[] sieve;
  static ArrayList<Integer> primes;

  public static void main(String[] args) throws IOException {

    sieveInit();
    t = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= t; tc++) {
      init();
      solve();
    }

    System.out.print(sb);
    br.close();
  }

  private static void init() throws IOException {
    k = Integer.parseInt(br.readLine()); // k: 5보다 큰 임의의 홀수
  }

  private static void solve() {

    int SIZE = primes.size();
    for (int i = 0; i < SIZE; i++) {
      if (k <= primes.get(i)) break;
      for (int j = i; j < SIZE; j++) {
        if (k <= primes.get(i) + primes.get(j)) break;
        for (int p = j; p < SIZE; p++) {
          if (k < primes.get(i) + primes.get(j) + primes.get(p)) break;
          else if (primes.get(i) + primes.get(j) + primes.get(p) == k) {
            sb.append(primes.get(i)).append(" ").append(primes.get(j)).append(" ").append(primes.get(p)).append("\n");
            return;
          }
        }
      }
    }
    sb.append(0).append("\n");
  }

  private static void sieveInit() {
    primes = new ArrayList<>();

    int LEN = 1_000;
    // 에라토스테네스의 체 구현
    sieve = new boolean[LEN + 1];
    sieve[0] = true; 
    sieve[1] = true;
    for (int i = 2; i <= LEN; i++) {
      if (!sieve[i]) {
        primes.add(i);
        for (int j = i * i; j <= LEN; j += i) {
          sieve[j] = true;
        }
      }
    }
  }
}
