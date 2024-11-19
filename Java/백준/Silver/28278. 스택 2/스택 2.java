import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        Deque<Integer> stk = new ArrayDeque<>();

        int n, command, value, flag;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    value = Integer.parseInt(st.nextToken());
                    stk.push(value);
                    break;
                    
                case 2:
                    if (stk.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(stk.pop() + "\n");
                    break;

                case 3:
                    bw.write(stk.size() + "\n");
                    break;

                case 4:
                    flag = stk.isEmpty() ? 1 : 0;
                    bw.write(flag + "\n");
                    break;

                case 5:
                    if (stk.isEmpty())
                        bw.write(-1 + "\n");
                    else
                        bw.write(stk.peek() + "\n");
                    break;
            }
        }

        bw.close();
    }
}