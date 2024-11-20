import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr = new int[6];

    public static void main(String[] args) throws IOException {

        int tc, n, idx, curr, total;

        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            idx = 0;
            curr = 0;
            total = 0;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            while (curr != n) {
                if (curr + arr[idx] > n) {
                    idx++;
                    if (idx == 6)
                        idx = 0;
                    continue;
                }

                curr += arr[idx];
                total += curr;

                idx++;
                if (idx == 6)
                    idx = 0;
            }
            System.out.println(total);
        }

    }
}