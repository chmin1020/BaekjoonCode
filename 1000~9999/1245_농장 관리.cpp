#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
typedef pair<int, int> pos;

bool isHillNow[100][100], isChecked[100][100];
int farm[100][100];
int n, m;
queue<pos> candidate, measure;

bool checkHeight(int height, pos loc) {
    if (isChecked[loc.first][loc.second]) return true;
    if (loc.first < 0 || loc.first >= n) return true;
    if (loc.second < 0 || loc.second >= m) return true;

    isChecked[loc.first][loc.second] = true;

    if (farm[loc.first][loc.second] > height) return false;
    if (farm[loc.first][loc.second] == height) {
        candidate.push(loc);
        measure.push(loc);
    }
    return true;
}

void findHill(int height, pos loc) {
    int x = loc.first, y = loc.second;

    if(!checkHeight(height, make_pair(x - 1, y - 1))) return;
    if(!checkHeight(height, make_pair(x - 1, y))) return;
    if(!checkHeight(height, make_pair(x - 1, y + 1))) return;
    if(!checkHeight(height, make_pair(x, y - 1))) return;
    if(!checkHeight(height, make_pair(x, y + 1))) return;
    if(!checkHeight(height, make_pair(x + 1, y - 1))) return;
    if(!checkHeight(height, make_pair(x + 1, y))) return;
    if(!checkHeight(height, make_pair(x + 1, y + 1))) return;

    measure.pop();
    if (measure.empty()) return;
    findHill(height, measure.front());
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int answer = 0;

    cin >> n >> m;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> farm[i][j];

    memset(isHillNow, false, sizeof(isHillNow));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            memset(isChecked, false, sizeof(isChecked));
            if (!isHillNow[i][j]) {
                isChecked[i][j] = true;
                measure.push(make_pair(i, j));
                candidate.push(make_pair(i, j));

                findHill(farm[i][j], make_pair(i, j));
                if (measure.empty()) {
                    answer++;
                    while (!candidate.empty()) {
                        isHillNow[candidate.front().first][candidate.front().second] = true;
                        candidate.pop();
                    }
                }
                while (!measure.empty()) measure.pop();
                while (!candidate.empty()) candidate.pop();
            }
        }
    }
    cout << answer;
    return 0;
}
