import java.util.*;
import java.io.*;

class Main {

    static class Info {

        int dir;
        int pos;

        public Info(int dir, int pos) {
            // 남쪽을 3으로 변환
            if (dir == 2)
                dir = 3;
                // 서쪽을 2로 변환
            else if (dir == 3)
                dir = 2;
            this.dir = dir;
            this.pos = pos;
        }
    }

    static class Point {

        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, S, SUM = 0;
    static ArrayList<Info> infos = new ArrayList<>();
    static int ds, de;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        S = Integer.parseInt(br.readLine());

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            infos.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        ds = Integer.parseInt(st.nextToken());
        de = Integer.parseInt(st.nextToken());

        // 남쪽을 3으로 변환
        if (ds == 2)
            ds = 3;
            // 서쪽을 2로 변환
        else if (ds == 3)
            ds = 2;

        for (Info info : infos) {
            int dist = getDist(info, ds, de);
            SUM += dist;
        }

        System.out.println(SUM);
    }

    private static int getDist(Info info, int ds, int de) {

        int dir = info.dir;
        int pos = info.pos;

        Point target = getPoint(dir, pos);
        Point start = getPoint(ds, de);

        int left = 0;
        int right = 0;
        // 반대 위치인 경우 -> 시계, 반시계 고려해야한다.
        if (Math.abs(dir - ds) == 2) {
            // 북쪽 <-> 남쪽인 경우
            if (dir == 1 || ds == 1) {
                left = de + N + pos;
                right = (M - de) + N + (M - pos);
                return Math.min(left, right);
            }
            // 동쪽 <-> 서쪽인 경우
            else if (dir == 2 || ds == 2) {

                left = (N - target.y) + M + (N - start.y);
                right = target.y + M + start.y;

                return Math.min(left, right);
            }
        }
        // 반대 위치가 아닌 경우 -> 맨해튼 거리를 반환
        return Math.abs(target.y - start.y) + Math.abs(target.x - start.x);
    }

    private static Point getPoint(int dir, int pos) {

        // 블록의 북쪽인 경우
        if (dir == 1)
            return new Point(0, pos);
        // 블록의 서쪽인 경우
        else if (dir == 2)
            return new Point(pos, 0);
        // 블록의 남쪽인 경우
        else if (dir == 3)
            return new Point(N, pos);
        // 블록의 동쪽인 경우
        else
            return new Point(pos, M);
    }
}