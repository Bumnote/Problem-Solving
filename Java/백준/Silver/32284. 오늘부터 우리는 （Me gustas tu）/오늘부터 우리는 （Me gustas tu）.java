import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {

    static Scanner sc = new Scanner(System.in);
    static char[][] MAP;
    static int N, M, a, b;

    static int[] dys = {-1, 1, 0, 0};
    static int[] dxs = {0, 0, -1, 1};

    public static void main(String[] args) {

        N = sc.nextInt();
        M = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        MAP = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 같은 위치인 경우
                if (a == i) {
                    // 같거나, 왼쪽에 있는 경우
                    if (j <= b)
                        MAP[i][j] = 'E';
                    // 오른쪽에 있는 경우
                    else
                        MAP[i][j] = 'W';
                }
                // 북쪽에 위치한 경우 -> 남쪽으로 이동
                else if (a < i) {
                    MAP[i][j] = 'N';
                }
                // 남쪽에 위치한 경우 -> 북쪽으로 이동
                else {
                    MAP[i][j] = 'S';
                }
                System.out.printf("%c", MAP[i][j]);
            }
            System.out.println();
        }


    }
}