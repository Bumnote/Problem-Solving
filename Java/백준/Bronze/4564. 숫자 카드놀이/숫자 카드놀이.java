import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    private static int getNextNumber(int curr) {
        int nextNumber = 1;
        while (curr > 0) {
            nextNumber *= (curr % 10);
            curr /= 10;
        }

        return nextNumber;
    }

    public static void main(String[] args) throws IOException {

        int num;
        while (true) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if (num == 0) break;

            while (true) {
                bw.write(num + " ");
                if (num < 10) break;
                num = getNextNumber(num);
            }

            bw.write("\n");
        }

        bw.close();
    }
}