import java.io.*;
import java.util.*;

class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final Integer SIZE = 10;
    static int T, M, A, y, x, aY, aX, bY, bX, nxtY, nxtX, c, p, sumA, sumB;
    static int[] arrA, arrB;
    static int[] dys = {0, -1, 0, 1, 0}, dxs = {0, 0, 1, 0, -1};
    static Set<Integer>[][] map;
    static Map<Integer, Integer> cache;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            init();

            solve(tc);

        }

        br.close();
        System.out.println(sb.toString());
    }

    private static void solve(int tc) {

        // 출발점 초기화
        aY = 1;
        aX = 1;
        bY = 10;
        bX = 10;

        int total = 0;
        int sum;
        for (int i = 0; i < M; i++) {

            sum = calculate(aY, aX, bY, bX); // 현재 위치에서 가장 최선의 상황을 계산
            total += sum;


            // 다음 칸으로 이동
            aY += dys[arrA[i]];
            aX += dxs[arrA[i]];

            bY += dys[arrB[i]];
            bX += dxs[arrB[i]];
        }

        total += calculate(aY, aX, bY, bX);
        sb.append(String.format("#%d %d", tc, total)).append("\n");
    }

    private static int calculate(int aY, int aX, int bY, int bX) {
        int MAX = 0;

        Set<Integer> s1 = map[aY][aX];
        Set<Integer> s2 = map[bY][bX];
        if (s1.isEmpty() && s2.isEmpty()) return 0;
        else if (!s1.isEmpty() && s2.isEmpty()) {
            for (Integer num : s1)
                MAX = Math.max(MAX, cache.get(num));
        } else if (s1.isEmpty() && !s2.isEmpty()) {
            for (Integer num : s2)
                MAX = Math.max(MAX, cache.get(num));
        } else {
            for (Integer num1 : s1) {
                for (Integer num2 : s2) {
                    if (!Objects.equals(num1, num2)) MAX = Math.max(MAX, cache.get(num1) + cache.get(num2));
                    else MAX = Math.max(MAX, cache.get(num1));
                }
            }
        }

        return MAX;
    }

    private static boolean inRange(int y, int x) {
        return 1 <= y && y <= SIZE && 1 <= x && x <= SIZE;
    }

    private static void init() throws IOException {

        // 입력 부분
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // M: 이동 시간
        A = Integer.parseInt(st.nextToken()); // A: BC의 개수


        map = new HashSet[SIZE + 1][SIZE + 1];
        for (int i = 0; i <= SIZE; i++) {
            for (int j = 0; j <= SIZE; j++) {
                map[i][j] = new HashSet<>();
            }
        }

        arrA = new int[M]; // A의 BC
        arrB = new int[M]; // B의 BC

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arrB[i] = Integer.parseInt(st.nextToken());

        cache = new HashMap<>();
        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); // x: 위치
            y = Integer.parseInt(st.nextToken()); // y: 위치
            c = Integer.parseInt(st.nextToken()); // c: 충전 범위
            p = Integer.parseInt(st.nextToken()); // p: 성능

            cache.put(i, p);
            for (int k = -c; k <= c; k++) {
                for (int t = -c; t <= c; t++) {
                    int moveCnt = Math.abs(k) + Math.abs(t);
                    if (moveCnt <= c) {
                        nxtY = y + k;
                        nxtX = x + t;
                        if (inRange(nxtY, nxtX))
                            map[nxtY][nxtX].add(i);
                    }
                }
            }
        }
    }
}
