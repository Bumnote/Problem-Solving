import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
    int[][] map = setUp(key, lock);
    boolean answer = false;

    for (int i = 0; i < 4; i++) {
      answer = check(key, lock, map);
      if (answer) {
        break;
      }
      directionChange(key);
    }

    return answer;
  }

  public int[][] setUp(int[][] key, int[][] lock) {
    int n = key[0].length;
    int m = lock[0].length;
    final int SIZE = 2 * (n - 1) + m;
    int[][] map = new int[SIZE][SIZE];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < m; j++) {
        map[n - 1 + i][n - 1 + j] = lock[i][j];
      }
    }

    return map;
  }

  public boolean check(int[][] key, int[][] lock, int[][] map) {
    int n = key[0].length;
    int m = lock[0].length;
    int SIZE = map[0].length;
    int totalCount = m * m;
    for (int i = 0; i <= SIZE - n; i++) {
      for (int j = 0; j <= SIZE - n; j++) {
        int[][] tmp = copyMap(map);
        for (int y = 0; y < n; y++) {
          for (int x = 0; x < n; x++) {
            tmp[i + y][j + x] += key[y][x];
          }
        }

        int count = 0;
        for (int y = 0; y < m; y++) {
          for (int x = 0; x < m; x++) {
            int flag = tmp[n - 1 + y][n - 1 + x];
            if (flag != 1) {
              continue;
            }
            count++;
          }
        }
        if (count == totalCount) {
          return true;
        }
      }
    }

    return false;
  }

  public int[][] copyMap(int[][] map) {
    final int SIZE = map[0].length;
    int[][] tmp = new int[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        tmp[i][j] = map[i][j];
      }
    }

    return tmp;
  }


  public void directionChange(int[][] key) {

    int SIZE = key[0].length;
    int[][] tmp = new int[SIZE][SIZE];

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        tmp[j][SIZE - i - 1] = key[i][j];
      }
    }

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        key[i][j] = tmp[i][j];
      }
    }
  }
}