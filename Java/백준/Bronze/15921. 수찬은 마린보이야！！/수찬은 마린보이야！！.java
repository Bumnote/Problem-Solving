import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        int n, sum = 0;
        double avg, e = 0.0;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        if (n == 0)
            System.out.println("divide by zero");
        else {
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            avg = (double) sum / n;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                e += k * ((double) v / n);
            }

            System.out.println(e != 0 ? String.format("%.2f", avg / e) : "divide by zero");

        }

    }
}