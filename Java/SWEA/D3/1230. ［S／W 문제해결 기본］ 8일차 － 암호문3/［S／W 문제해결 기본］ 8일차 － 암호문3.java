import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, x, y, s;
    static LinkedList<Integer> lst;
    static Stack<Integer> stk = new Stack<>();
    static char command;

    public static void main(String[] args) throws IOException {

        for (int tc = 1; tc <= 10; tc++) {

            N = Integer.parseInt(br.readLine());
            lst = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                lst.add(Integer.parseInt(st.nextToken()));

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                command = st.nextToken().charAt(0);

                switch (command) {
                    case 'I':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < y; i++)
                            stk.add(Integer.parseInt(st.nextToken()));

                        while (!stk.isEmpty())
                            lst.add(x, stk.pop());
                        break;

                    case 'D':
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < y; i++)
                            lst.remove(x);

                        break;

                    case 'A':
                        y = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < y; i++)
                            lst.add(Integer.parseInt(st.nextToken()));
                        break;
                }
            }

            // 정답 출력 부분
            bw.write("#" + tc + " ");
            for (int i = 0; i < 10; i++)
                bw.write(lst.get(i) + " ");
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
