import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            st.nextToken();
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}