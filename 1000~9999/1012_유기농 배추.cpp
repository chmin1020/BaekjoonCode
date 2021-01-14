#include <iostream>
#include <cstring>
using namespace std;
bool field[50][50], visited[50][50];

void check(int x, int y, int xLim, int yLim) {
	if (!field[x][y] || visited[x][y]) return;
	visited[x][y] = true;

	if (x > 0 && field[x - 1][y]) check(x - 1, y, xLim, yLim);
	if (x < xLim - 1 && field[x + 1][y]) check(x + 1, y, xLim, yLim);
	if (y > 0 && field[x][y - 1]) check(x, y - 1, xLim, yLim);
	if (y < yLim - 1 && field[x][y + 1]) check(x, y + 1, xLim, yLim);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int t, m, n ,k;
	int x, y, cnt;

	cin >> t;
	for (int i = 0; i < t; i++) {
		memset(field, false, sizeof(field));
		memset(visited, false, sizeof(visited)); cnt = 0;
		cin >> m >> n >> k;
		for (int j = 0; j < k; j++) {
			cin >> x >> y;
			field[x][y] = true;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (field[i][j] && !visited[i][j]) cnt++;
				check(i, j, m, n);
			}
		}
		cout << cnt << '\n';
	}
	return 0;
}
