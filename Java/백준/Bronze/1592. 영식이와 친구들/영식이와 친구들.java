import java.io.*;
import java.util.*;

class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = sc.nextInt(); // 1 ~ N
        int M = sc.nextInt(); // M: 공을 받는 횟수
        int L = sc.nextInt(); // L: 위치

        int[] arr = new int[N + 1];
        int curr = 1, cnt = 0;
        while (true) {

            arr[curr] += 1;
            // 한 사람이 공을 M번 받았으면 게임은 끝난다.
            if (arr[curr] >= M)
                break;

            // 공을 받은 횟수가 홀수인 경우 -> 시계 방향
            if (arr[curr] % 2 == 1) {
                curr = (curr + L) % N;
                cnt++;
            }
            // 공을 받은 횟수가 짝수인 경우 -> 반시계 방향
            else {
                curr = (N + curr - L) % N;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}