import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[] A, B;
    static Map<Integer, Integer> mapA;
    static Map<Integer, Integer> mapB;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            setUp();

            char winner = getWinner();
            bw.write(winner + "\n");
        }

        bw.close();
    }

    private static void setUp() throws IOException {

        mapA = initMap();
        mapB = initMap();

        st = new StringTokenizer(br.readLine());
        A = processInput(st, mapA);

        st = new StringTokenizer(br.readLine());
        B = processInput(st, mapB);
    }

    // 4: 별, 3: 동그라미, 2: 네모, 1: 세모
    private static char getWinner() {

        // 별의 개수가 다른 경우
        if (mapA.get(4) < mapB.get(4)) return 'B';
        else if (mapA.get(4) > mapB.get(4)) return 'A';
        // 별의 개수가 같은 경우
        else {
            // 동그라미 개수가 같은 경우
            if (mapA.get(3) < mapB.get(3)) return 'B';
            else if (mapA.get(3) > mapB.get(3)) return 'A';
            // 동그라미 개수가 다른 경우
            else {
                // 네모 개수가 같은 경우
                if (mapA.get(2) < mapB.get(2)) return 'B';
                else if (mapA.get(2) > mapB.get(2)) return 'A';
                // 네모 개수가 다른 경우
                else {
                    if (mapA.get(1) < mapB.get(1)) return 'B';
                    else if (mapA.get(1) > mapB.get(1)) return 'A';
                    else return 'D';
                }
            }
        }
    }

    private static Map<Integer, Integer> initMap() {
        return new HashMap<Integer, Integer>() {{
            put(4, 0);
            put(3, 0);
            put(2, 0);
            put(1, 0);
        }};
    }

    private static int[] processInput(StringTokenizer st, Map<Integer, Integer> map) {
        int cnt = Integer.parseInt(st.nextToken());
        int[] arr = new int[cnt];

        for (int j = 0; j < cnt; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }
        return arr;
    }

}

