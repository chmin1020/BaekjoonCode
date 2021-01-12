#include <iostream>
#include <cstring>
using namespace std;
int path[500][500], map[500][500];
bool visited[500][500];
int m, n;

void findPath(int x, int y) {
	visited[x][y] = true;
	if (x > 0) { //top
		if (map[x - 1][y] < map[x][y]) {
			if (!visited[x - 1][y]) findPath(x - 1, y);
			path[x][y] += path[x - 1][y];
		}
	}
	if (x < m - 1) { //bottom
		if (map[x + 1][y] < map[x][y]) {
			if (!visited[x + 1][y]) findPath(x + 1, y);
			path[x][y] += path[x + 1][y];
		}
	}
	if (y > 0) { //left
		if (map[x][y - 1] < map[x][y]) {
			if (!visited[x][y - 1]) findPath(x, y - 1);
			path[x][y] += path[x][y - 1];
		}
	}
	if (y < n - 1) { //right
		if (map[x][y + 1] < map[x][y]) {
			if (!visited[x][y + 1]) findPath(x, y + 1);
			path[x][y] += path[x][y + 1];
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(path, 0, sizeof(path));
	memset(visited, false, sizeof(visited));

	cin >> m >> n;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < n; j++)
			cin >> map[i][j];
	path[m - 1][n - 1] = 1;
	findPath(0, 0);
	cout << path[0][0] << "\n";
	return 0;
}
