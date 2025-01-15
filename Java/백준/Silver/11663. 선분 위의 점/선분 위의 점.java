import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] points;
    static int N, M, s, e; // N: 점의 개수, M: 선분의 개수

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            points[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(points); // 이분 탐색을 위한 오름차순 정렬
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            int cnt = upperBound(e) - lowerBound(s) + 1;

            bw.write(cnt + "\n");
        }

        bw.close();
    }

    // target 값의 인덱스
    // target 값이 존재하지 않는다면 target 값보다 크면서 가장 작은 값의 인덱스 반환
    private static int upperBound(int target) {

        int left = 0;
        int right = N - 1;

        int idx = -1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (points[mid] <= target) {
                // 인덱스는 큰 값 중에서 가장 작은 값을 저장
                if (idx < mid)
                    idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return idx;
    }

    // target 값의 인덱스
    // target 값이 존재하지 않는다면 target 값보다 작으면서 가장 큰 값의 인덱스 반환
    private static int lowerBound(int target) {

        int left = 0;
        int right = N - 1;

        int idx = N;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= points[mid]) {
                if (idx > mid)
                    idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return idx;
    }
}
