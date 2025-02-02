import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static String word;
    static boolean isTrue, flag;
    static ArrayList<ArrayDeque<String>> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            lst.add(new ArrayDeque<String>());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                lst.get(i).add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        isTrue = true;

        while (st.hasMoreTokens()) {
            flag = true;
            word = st.nextToken();

            for (ArrayDeque<String> dq : lst) {
                if (!dq.isEmpty() && dq.peek().equals(word)) {
                    dq.poll();
                    flag = false;
                    break;
                }
            }

            if (flag) {
                isTrue = false;
                break;
            }
        }

        for (ArrayDeque<String> dq : lst) {
            // 앵무새가 말할 단어가 더 남아있는 경우 -> 규칙에 어긋나므로 false
            if (!dq.isEmpty()) {
                isTrue = false;
                break;
            }
        }

        System.out.println(isTrue ? "Possible" : "Impossible");
    }
}

