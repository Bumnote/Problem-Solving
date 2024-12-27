import java.util.*;

class Solution {
    static int T, n, m, ans;
    static int[][] arr;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            // 입력
            n = sc.nextInt();
            m = sc.nextInt();

            arr = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();

            // 문제 해결
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sumA = arr[i][j];
                    int sumB = arr[i][j];
                    for (int d = 1; d <= m - 1; d++) {
                        for (int k = 0; k < 4; k++) {
                            int[] dys = {-d, d, 0, 0};
                            int[] dxs = {0, 0, -d, d};

                            int[] diys = {-d, -d, d, d};
                            int[] dixs = {-d, d, d, -d};

                            if (inRange(i + dys[k], j + dxs[k])) {
                                sumA += arr[i + dys[k]][j + dxs[k]];
                            }
                            if (inRange(i + diys[k], j + dixs[k])) {
                                sumB += arr[i + diys[k]][j + dixs[k]];
                            }
                        }
                    }
                    int sum = Math.max(sumA, sumB);
                    ans = Math.max(ans, sum); // 최대 파리 수 갱신
                }
            }

            // 정답 출력
            System.out.printf("#%d %d\n", test_case, ans);
        }
    }

    public static boolean inRange(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < n;
    }
}