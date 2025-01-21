import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int MIN = Integer.MAX_VALUE;
        int left = 0;
        int right = N - 1;

        int[] ans = new int[2];
        while (left < right) {

            int sum = arr[left] + arr[right];
            if (MIN > Math.abs(sum)) {
                MIN = Math.abs(sum);
                ans[0] = arr[left];
                ans[1] = arr[right];
            }

            // 용액의 특성값이 0인 경우
            if (sum == 0) break;
            // 용액의 특성값이 양수인 경우 -> 오른쪽--
            else if (sum > 0) right--;
            // 용액의 특성값이 음수인 경우 -> 왼쪽++
            else left++;
        }

        System.out.printf("%d %d\n", ans[0], ans[1]);
    }


}