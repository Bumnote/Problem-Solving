import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {

        int n, person, cnt = 0;
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i > 0)
                pq.offer(-arr[i]);
        }

        while (!pq.isEmpty()) {
            person = -pq.poll();

            if (arr[0] <= person) {
                arr[0]++;
                cnt++;
                pq.offer(-(person - 1));
            } else
                break;
        }
        System.out.println(cnt);

    }
}