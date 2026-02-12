import java.util.*;

class Solution {

    // 기둥 = 1
    // 보 = 2
    int[][] map;
    int n;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        map = new int[n + 1][n + 1];

        for (int[] bf : build_frame) {
            int x = bf[0];
            int y = bf[1];
            int a = bf[2];
            int b = bf[3];

            if (b == 1) { // 설치
                if (a == 0) { // 기둥
                    if (checkPillar(y, x)) {
                        map[y][x] |= 1;
                    }
                } else { // 보
                    if (checkBar(y, x)) {
                        map[y][x] |= 2;
                    }
                }
            } else { // 삭제
                if (a == 0) { // 기둥 삭제
                    map[y][x] &= ~1;
                    if (!isValidAll()) {
                        map[y][x] |= 1;
                    }
                } else { // 보 삭제
                    map[y][x] &= ~2;
                    if (!isValidAll()) {
                        map[y][x] |= 2;
                    }
                }
            }
        }

        // 결과 수집
        List<int[]> result = new ArrayList<>();

        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                if ((map[y][x] & 1) != 0) { // 기둥
                    result.add(new int[]{x, y, 0});
                }
                if ((map[y][x] & 2) != 0) { // 보
                    result.add(new int[]{x, y, 1});
                }
            }
        }

        // 정렬 (x 오름차순 → y 오름차순 → 구조물 종류)
        result.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        return result.toArray(new int[result.size()][]);
    }

    private boolean checkPillar(int y, int x) {
        // 바닥
        if (y == 0) return true;

        // 아래 기둥
        if ((map[y - 1][x] & 1) != 0) return true;

        // 왼쪽 보
        if (x > 0 && (map[y][x - 1] & 2) != 0) return true;

        // 현재 위치 보
        if ((map[y][x] & 2) != 0) return true;

        return false;
    }

    private boolean checkBar(int y, int x) {
        // 왼쪽 아래 기둥
        if (y > 0 && (map[y - 1][x] & 1) != 0) return true;

        // 오른쪽 아래 기둥
        if (y > 0 && x + 1 <= n && (map[y - 1][x + 1] & 1) != 0) return true;

        // 양쪽 보
        if (x > 0 && x + 1 <= n &&
            (map[y][x - 1] & 2) != 0 &&
            (map[y][x + 1] & 2) != 0) return true;

        return false;
    }

    private boolean isValidAll() {
        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                if ((map[y][x] & 1) != 0 && !checkPillar(y, x)) {
                    return false;
                }
                if ((map[y][x] & 2) != 0 && !checkBar(y, x)) {
                    return false;
                }
            }
        }
        return true;
    }
}
