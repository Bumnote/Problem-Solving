import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int t, MAX = 100_000_000;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        // 에라토스테네스의 체 구현
        boolean[] sieve = new boolean[MAX + 1];
        for (int i = 2; i <= Math.sqrt(MAX); i++)
            if (!sieve[i])
                for (int j = i * i; j <= MAX; j += i)
                    sieve[j] = true;

        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            arr = new int[cnt];

            for (int i = 0; i < cnt; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int len = Integer.MAX_VALUE;
            int[] ans = null;
            for (int i = 0; i < cnt; i++) {
                int sum = arr[i];
                for (int j = i + 1; j < cnt; j++) {
                    sum += arr[j];
                    // 소수이면서, 길이 갱신이 가능한 경우 -> 저장
                    if (!sieve[sum] && j - i + 1 < len) {
                        len = j - i + 1;
                        ans = Arrays.copyOfRange(arr, i, j + 1);
                    }
                }
            }

            if (ans != null) {
                for (int num : ans)
                    sb.append(num).append(" ");
                bw.write(String.format("Shortest primed subsequence is length %d: %s\n", len, sb.toString()));
                sb.setLength(0); // 객체 초기화
            } else
                bw.write("This sequence is anti-primed.\n");

        }

        bw.close();
    }

}

