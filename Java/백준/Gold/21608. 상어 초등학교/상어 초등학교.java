import java.io.*;
import java.util.*;

class Main {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder sb = new StringBuilder();
  private static StringTokenizer st;

  private static int n;
  private static int map[][];
  private static int order[];
  private static final Map<Integer, List<Integer>> studentFavoriteMap = new HashMap<>();
  private static final int[] dys = {-1, 1, 0, 0}, dxs = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    init();
    solve();
  }

  private static void init() throws IOException {
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    order = new int[n * n];
    for (int i = 0; i < n * n; i++) {
      st = new StringTokenizer(br.readLine());
      int studentNum = Integer.parseInt(st.nextToken());
      order[i] = studentNum;
      List<Integer> favoriteStudents = new ArrayList<>();
      for (int j = 0; j < 4; j++) {
        favoriteStudents.add(Integer.parseInt(st.nextToken()));
      }
      studentFavoriteMap.put(studentNum, favoriteStudents);
    }
    br.close();
  }

  private static void solve() {

    /*
    Rule
    1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    * */
    for (int i = 0; i < n * n; i++) {
      int studentNum = order[i];
      List<Integer> favoriteStudents = studentFavoriteMap.get(studentNum);

      List<int[]> nearByFavoriteStudentList = calculateNearByFavoriteStudentList(favoriteStudents);
      // 1번 규칙을 만족한다면 -> 해당 칸에 자리 배치
      if (nearByFavoriteStudentList.size() == 1) {
        int[] selectedPosition = nearByFavoriteStudentList.get(0);
        map[selectedPosition[0]][selectedPosition[1]] = studentNum;
        continue;
      }

      List<int[]> nearByEmptyCountList = calculateNearByEmptyCountList(nearByFavoriteStudentList);
      // 2번 규칙을 만족한다면 -> 해당 칸에 자리 배치
      if (nearByEmptyCountList.size() == 1) {
        int[] selectedPosition = nearByEmptyCountList.get(0);
        map[selectedPosition[0]][selectedPosition[1]] = studentNum;
        continue;
      }

      // 3번 규칙을 만족한다면 -> 행, 열 번호가 가장 작은 칸에 자리 배치
      int[] selectedPosition = nearByEmptyCountList.get(0);
      map[selectedPosition[0]][selectedPosition[1]] = studentNum;
    }

    int answer = calculateSatisfaction();
    System.out.println(answer);
  }

  private static List<int[]> calculateNearByFavoriteStudentList(List<Integer> favoriteStudents) {
    List<int[]> result = new ArrayList<>();

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // 이미 학생이 배치된 경우 -> continue
        if (map[i][j] != 0) {
          continue;
        }
        int favoriteStudentCount = 0;
        for (int d = 0; d < 4; d++) {
          int ny = i + dys[d];
          int nx = j + dxs[d];
          if (inRange(ny, nx) && map[ny][nx] != 0) {
            for (Integer favoriteStudentNum : favoriteStudents) {
              if (map[ny][nx] == favoriteStudentNum) {
                favoriteStudentCount++;
              }
            }
          }
        }

        if (max < favoriteStudentCount) {
          max = favoriteStudentCount;
          result.clear();
          result.add(new int[]{i, j});
        } else if (max == favoriteStudentCount) {
          result.add(new int[]{i, j});
        }
      }
    }

    return result;
  }

  private static List<int[]> calculateNearByEmptyCountList(List<int[]> nearByFavoriteStudentList) {
    List<int[]> result = new ArrayList<>();
    int max = 0;
    for (int[] pos : nearByFavoriteStudentList) {
      int y = pos[0];
      int x = pos[1];
      int emptyCount = 0;
      for (int d = 0; d < 4; d++) {
        int ny = y + dys[d];
        int nx = x + dxs[d];
        if (inRange(ny, nx) && map[ny][nx] == 0) {
          emptyCount++;
        }
      }

      if (max < emptyCount) {
        max = emptyCount;
        result.clear();
        result.add(new int[]{y, x});
      } else if (max == emptyCount) {
        result.add(new int[]{y, x});
      }
    }

    return result;
  }

  private static int calculateSatisfaction() {
    int satisfaction = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int favoriteFriendCount = 0;
        for (int d = 0; d < 4; d++) {
          int ny = i + dys[d];
          int nx = j + dxs[d];
          if (inRange(ny, nx)) {
            int studentNum = map[i][j];
            for (int favoriteStudent : studentFavoriteMap.get(studentNum)) {
              if (map[ny][nx] == favoriteStudent) {
                favoriteFriendCount++;
              }
            }
          }
        }

        if (favoriteFriendCount == 0) {
          satisfaction += 0;
        } else if (favoriteFriendCount == 1) {
          satisfaction += 1;
        } else if (favoriteFriendCount == 2) {
          satisfaction += 10;
        } else if (favoriteFriendCount == 3) {
          satisfaction += 100;
        } else if (favoriteFriendCount == 4) {
          satisfaction += 1000;
        }
      }
    }

    return satisfaction;
  }

  private static boolean inRange(int y, int x) {
    return 0 <= y && y < n && 0 <= x && x < n;
  }
}