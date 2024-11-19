import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[] arr = new int[6];
        st = new StringTokenizer(br.readLine());

        int total = 0;
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i] * 5;
        }

        bw.write(total + "\n");
        bw.flush();
        bw.close();
    }
}