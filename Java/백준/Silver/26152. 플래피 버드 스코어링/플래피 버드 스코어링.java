import java.util.*;
import java.io.*;

public class Main {

    static class Bird {
        int index;
        int size;
        int cnt;

        public Bird(int index, int size) {
            this.index = index;
            this.size = size;
            this.cnt = 0;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, Q;
    static int[] A, B, W;
    static ArrayList<Bird> birds = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        setUp();

        inGame();

        getScore();
    }

    private static void getScore() throws IOException {

        for (Bird bird : birds) {
            bw.write(bird.cnt + "\n");
        }

        bw.close();
    }

    private static void inGame() {

        int start = 0;
        int cnt = 0;
        for (Bird bird : birds) {

            for (int i = start; i < N; i++) {
                int diff = A[i] - B[i];

                if (diff >= bird.size) {
                    cnt++;
                    if (i == N - 1)
                        start = N;
                } else {
                    start = i;
                    break;
                }
            }

            bird.cnt = cnt;
        }

        birds.sort(Comparator.comparingInt(a -> a.index)); // 인덱스 기준으로 오름차순 정렬
    }

    private static void setUp() throws IOException {

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Q = Integer.parseInt(br.readLine());
        W = new int[Q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            W[i] = Integer.parseInt(st.nextToken());
            birds.add(new Bird(i, W[i]));
        }

        birds.sort((a, b) -> b.size - a.size); // 크기를 기준으로 내림차순 정렬
    }
}

