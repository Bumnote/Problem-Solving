import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N; // N: 버퍼의 크기
    static int packet;
    static ArrayDeque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        while (true) {

            packet = Integer.parseInt(br.readLine());
            if (packet == -1) {
                if (!dq.isEmpty()) {
                    for (Integer p : dq)
                        bw.write(p + " ");
                } else bw.write("empty");
                break;
            }
            if (packet == 0) {
                dq.poll();
                continue;
            }

            if (dq.size() < N)
                dq.offer(packet);
        }

        br.close();
        bw.close();
    }
}

