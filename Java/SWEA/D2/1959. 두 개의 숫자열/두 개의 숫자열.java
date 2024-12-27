import java.util.*;

class Solution {

    static Scanner sc = new Scanner(System.in);
    static int T, N, M, MAX, SUM;
    static int[] A;
    static int[] B;

    public static void main(String[] args) {

        T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            M = sc.nextInt();
            A = new int[N];
            B = new int[M];

            for (int i = 0; i < N; i++)
                A[i] = sc.nextInt();

            for (int i = 0; i < M; i++)
                B[i] = sc.nextInt();

            MAX = 0;
            if (N <= M) {
                for (int i = 0; i <= M - N; i++) {
                    SUM = 0;
                    for (int j = 0; j < N; j++) {
                        SUM += A[j] * B[i + j];
                    }
                    MAX = Math.max(MAX, SUM);
                }
            } else {
                for (int i = 0; i <= N - M; i++) {
                    SUM = 0;
                    for (int j = 0; j < M; j++) {
                        SUM += B[j] * A[i + j];
                    }
                    MAX = Math.max(MAX, SUM);
                }
            }

            System.out.printf("#%d %d\n", tc, MAX);
        }

    }
}