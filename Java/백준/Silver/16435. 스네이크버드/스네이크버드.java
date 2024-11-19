import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N, l;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int elem : arr) {
            if (elem <= l) l++;
        }

        bw.write(l + "\n");
        bw.flush();
        bw.close();
    }
}