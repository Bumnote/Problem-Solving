import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S, GCD;
    static int[] arr;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            nums[i] = Math.abs(arr[i] - S);
        }

        GCD = nums[0];
        for (int num : nums) {
            GCD = getGcd(GCD, num);
        }

        System.out.println(GCD);
    }

    private static int getGcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}