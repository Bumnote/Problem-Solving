import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr = new int[4][5];

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 공격력
            arr[i][1] = Integer.parseInt(st.nextToken()); // 힘
            arr[i][2] = Integer.parseInt(st.nextToken()); // 치명타 확률
            arr[i][3] = Integer.parseInt(st.nextToken()); // 치명타 피해비율
            arr[i][4] = Integer.parseInt(st.nextToken()); // 공격속도 증가
        }

        double aA = getPower(arr[0][0], arr[0][1], arr[0][2], arr[0][3], arr[0][4]); // 무기 장착 "크리"
        double aB = getPower(arr[1][0], arr[1][1], arr[1][2], arr[1][3], arr[1][4]); // 무기 장착 "파부"

        // 파부 무기 장착한 "크리"
        double bA = getPower(
                arr[0][0] - arr[2][0] + arr[3][0],
                arr[0][1] - arr[2][1] + arr[3][1],
                arr[0][2] - arr[2][2] + arr[3][2],
                arr[0][3] - arr[2][3] + arr[3][3],
                arr[0][4] - arr[2][4] + arr[3][4]
        );
        // 크리 무기 장착한 "파부"
        double bB = getPower(
                arr[1][0] - arr[3][0] + arr[2][0],
                arr[1][1] - arr[3][1] + arr[2][1],
                arr[1][2] - arr[3][2] + arr[2][2],
                arr[1][3] - arr[3][3] + arr[2][3],
                arr[1][4] - arr[3][4] + arr[2][4]
        );

        if (aA < bA)
            System.out.println("+");
        else if (aA > bA)
            System.out.println("-");
        else
            System.out.println("0");

        if (aB < bB)
            System.out.println("+");
        else if (aB > bB)
            System.out.println("-");
        else
            System.out.println("0");

    }

    private static double getPower(int a, int b, int c, int d, int e) {
        return a
                * (1 + (double) b / 100)
                * ((1 - Math.min((double) c / 100, 1)) + Math.min((double) c / 100, 1) * (double) d / 100)
                * (1 + (double) e / 100);
    }
}
