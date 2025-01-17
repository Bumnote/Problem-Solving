import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int[] res = bs();
        System.out.printf("%d %d\n", res[0], res[1]);

    }

    private static int[] bs() {

        int left = 0;
        int right = N - 1;

        int MIN = Integer.MAX_VALUE;
        int[] res = null;

        // 모든 숫자가 양수인 경우
        if (arr[left] > 0)
            return new int[]{arr[left], arr[left + 1]};

        // 모든 숫자가 음수인 경우
        if (arr[right] < 0)
            return new int[]{arr[right - 1], arr[right]};

        // 양수와 음수 모두 존재하는 경우
        while (left < right) {

            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < MIN) {
                MIN = Math.abs(sum);
                res = new int[]{arr[left], arr[right]};
            }

            if (sum == 0)
                return new int[]{arr[left], arr[right]};
            else if (sum < 0) {
                left++;
            } else
                right--;
        }

        return res;
    }

}
