import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T, N;
    static Set<Integer> s;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            s = new HashSet<>();
            N = Integer.parseInt(br.readLine());

            int num = N;
            while (true) {
                saveNum(num);

                if (s.size() == 10) {
                    bw.write(String.format("#%d %d\n", tc, num));
                    break;
                }

                num += N;
            }
        }

        br.close();
        bw.close();
    }

    private static void saveNum(int num) {

        String sNum = String.valueOf(num);
        for (char n : sNum.toCharArray()) {
            s.add(n - '0');
        }
    }
}

