import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] money;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            sum += money[i];
        }

        int ans = bs(sum); // 이분 탐색 진행
        System.out.println(ans);
    }

    private static int bs(int end) {

        int left = 1;
        int right = end;

        int ans = Integer.MAX_VALUE;
        while (left <= right) {

            int mid = (left + right) / 2;
            int cnt = simulate(mid); // 해당 금액으로 시뮬레이션 진행

            // 인출 횟수가 M번 또는 M번 보다 적은 경우 -> 금액을 줄인다.
            if (M >= cnt) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else left = mid + 1;
        }

        return ans;
    }

    private static int simulate(int m) {

        int cnt = 0;
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            // 인출한 금액으로 하루를 보낼 수 없는 경우
            if (money[i] > m) {
                flag = false; // 불가능 처리
                break;
            }
            // 돈이 부족하면, 남은 금액을 통장에 넣고, 다시 m원 인출
            if (money[i] > sum) {
                sum = m;
                cnt++;
            }

            sum -= money[i];
        }

        return flag ? cnt : M + 1;
    }
}

