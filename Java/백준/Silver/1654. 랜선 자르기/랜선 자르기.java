import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int K, N;
    static long MAX = 1;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        for (int i = 0; i < K; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr); // 이분 탐색을 위한 오름차순 정렬
        long ans = bs();

        System.out.println(ans);
    }

    private static long bs() {
        long left = 1;
        long right = arr[K - 1];

        while (left <= right) {
            long mid = (left + right) / 2; // mid: 가능한 랜선의 개수
            long SUM = 0;
            for (int num : arr)
                SUM += (num / mid); // 랜선의 개수를 모두 더한다.

            // 원하는 랜선의 개수와 같거나 많다면 -> 하한을 변경한다.
            if (N <= SUM) {
                // 랜선의 길이가 더 길다면 -> 갱신한다.
                if (MAX < mid)
                    MAX = mid;
                left = mid + 1;
                // 원하는 랜선의 개수보다 적다면 -> 상한을 변경한다.
            } else
                right = mid - 1;
        }

        return MAX;
    }
}