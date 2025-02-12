import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        init();

        solve();

    }

    private static void solve() {
        int SUM = 0, MAX = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (SUM + nums[i] < 0) {
                SUM = 0;
                MAX = Math.max(MAX, nums[i]);
            } else {
                SUM += nums[i];
                MAX = Math.max(MAX, SUM);
            }
        }

        System.out.println(MAX);
    }


    private static void init() throws IOException {

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        br.close();
    }
}