import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, MAX = 80_001, sum = 0;
    static boolean[] sieve = new boolean[MAX];
    static int[] numbers;

    public static void main(String[] args) throws Exception {

        // 전처리
        for (int i = 1; i < MAX; i++)
            if (i % 3 == 0 || i % 7 == 0)
                sieve[i] = true;

        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        numbers = new int[T];
        for (int i = 0; i < T; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int curr = 1;
        for (int number : numbers) {
            for (int i = curr + 1; i <= number; i++) {
                sum += sieve[i] ? i : 0;
            }
            curr = number;
            sb.append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }

}