import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static long D; // N: 방의 수, D: 시작 전투력
    static PriorityQueue<Integer> monster = new PriorityQueue<>();
    static PriorityQueue<Integer> weapon = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (command == 1)
                monster.add(num);
            else
                weapon.add(num);
        }

        int cnt = 0;
        boolean flag = true;
        // 전투력에 장비의 전투력이 곱해지므로, 몬스터를 최대한 많이 잡고, 장비를 얻어보자.
        while (true) {

            while (!monster.isEmpty() && D > monster.peek()) {
                int monsterPower = monster.poll();
                D += monsterPower;
                cnt++; // 몬스터 방 돌파
                flag = false;
            }

            if (!weapon.isEmpty()) {
                D *= weapon.poll();
                cnt++; // 장비 방 돌파
                flag = false;
            }

            if (flag)
                break;

            flag = true; // 초기화
        }

        System.out.println(cnt);
    }
}
