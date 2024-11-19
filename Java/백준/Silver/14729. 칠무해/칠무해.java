import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static double[] arr;

    public static void main(String[] args) throws IOException {

        int n;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new double[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < 7; i++)
            bw.write(String.format("%.3f", arr[i]) + "\n");

        bw.close();
    }
}