#include <iostream>
#include <algorithm>
using namespace std;
char board[55][55];
int n, m,ans;
int dx[8] = { 0,-1,-1,-1,0,1,1,1 };
int dy[8] = { 1,1,0,-1,-1,-1,0,1 };
int recover(int x,int y) {
    char a = 'A' + x;
    char b = 'A' + y;
    int ret = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == a) {
                for (int k = 0; k < 8; k++) {
                    bool ok = true;
                    int nx = i;
                    int ny = j;
                    for (int q = 0; q < 2; q++) {
                        nx += dx[k];
                        ny += dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (board[nx][ny] != b)  ok = false;
                        }
                        else ok = false;
                    }
                    if(ok) ret++;
                }
            }
        }
    }
    return ret;
}
int main() {
    scanf(" %d %d", &n, &m);
    for (int i = 0; i < n; i++) scanf(" %s", &board[i]);
    
    for (int i = 0; i < 26; i++) {
        if (i == 'M' - 'A') continue;
        for (int j = 0; j < 26; j++) {
            if (i == j || j=='O'-'A') continue;
            ans = max(ans, recover(i, j));
        }
    }
    printf("%d\n", ans);
}