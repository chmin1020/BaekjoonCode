#include <iostream>
#include <cstring>
using namespace std;
typedef pair<int, int> pos;

char map[5][5];
bool isVisited[5][5];
pos start, des;
int R, C, k, ans = 0;

void findWay(pos cur, int cnt) {
    if (k < cnt || map[cur.first][cur.second] == 'T') return;
    if (cur == des) {
        if (k == cnt) ans++;
        return;
    }
    isVisited[cur.first][cur.second] = true;

    if (cur.first - 1 >= 0 && !isVisited[cur.first - 1][cur.second])
        findWay(make_pair(cur.first - 1, cur.second), cnt + 1);
    if (cur.first + 1 < R && !isVisited[cur.first + 1][cur.second])
        findWay(make_pair(cur.first + 1, cur.second), cnt + 1);
    if (cur.second - 1 >= 0 && !isVisited[cur.first][cur.second - 1])
        findWay(make_pair(cur.first, cur.second - 1), cnt + 1);
    if (cur.second + 1 < C && !isVisited[cur.first][cur.second + 1])
        findWay(make_pair(cur.first, cur.second + 1), cnt + 1);
    
    isVisited[cur.first][cur.second] = false;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    cin >> R >> C >> k;
    for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++)
            cin >> map[i][j];
    start.first = R - 1; start.second = 0;
    des.first = 0; des.second = C - 1;
    memset(isVisited, false, sizeof(isVisited));

    findWay(start, 1);
    cout << ans;          
    return 0;
}
