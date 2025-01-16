import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, MAX = 0, MIN = -1; // N: 강의의 개수, M: 녹화할 블루레이의 개수
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            MAX += arr[i];
            MIN = Math.max(MIN, arr[i]);
        }

        System.out.println(bs());
    }

    private static int bs() {

        int left = MIN;
        int right = MAX;
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int sum = 0;
            int cnt = 0;
            int mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                if (sum + arr[i] <= mid) {
                    if (i == N - 1)
                        cnt++;
                    sum += arr[i];
                } else {
                    cnt++;
                    sum = arr[i];
                    if (i == N - 1)
                        cnt++;
                }
            }
            // 목표 개수와 같거나 적게 나오는 경우 -> 블루레이 크기를 줄인다.
            if (cnt <= M) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            // 목표 개수보다 더 많이 나오는 경우 -> 블루레이 크기를 늘린다.
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
