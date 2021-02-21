#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
bool visited[50][50], map[50][50];

void init() {
	memset(visited, false, sizeof(visited));
	memset(map, false, sizeof(map));
}
void getMap(int w, int h) {
	for (int i = 0; i < h; i++)
		for (int j = 0; j < w; j++)
			cin >> map[i][j];
}
int countIsland(int w, int h) {
	queue<pair<int, int>> q;
	int cnt = 0, cX, cY;

	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (map[i][j] && !visited[i][j]) {
				q.push(make_pair(i, j)); visited[i][j] = true;
				while (!q.empty()) {
					cX = q.front().first; cY = q.front().second;

					//가로 세로
					if (cX > 0 && map[cX - 1][cY] && !visited[cX - 1][cY]) {
						q.push(make_pair(cX - 1, cY)); visited[cX - 1][cY] = true;
					}
					if (cX < h - 1 && map[cX + 1][cY] && !visited[cX + 1][cY]) {
						q.push(make_pair(cX + 1, cY)); visited[cX + 1][cY] = true;
					}
					if (cY > 0 && map[cX][cY - 1] && !visited[cX][cY - 1]) {
						q.push(make_pair(cX, cY - 1)); visited[cX][cY - 1] = true;
					}
					if (cY < w - 1 && map[cX][cY + 1] && !visited[cX][cY + 1]) {
						q.push(make_pair(cX, cY + 1)); visited[cX][cY + 1] = true;
					}
					//대각선
					if (cX > 0 && cY > 0 && map[cX - 1][cY - 1] && !visited[cX - 1][cY - 1]) {
						q.push(make_pair(cX - 1, cY - 1)); visited[cX - 1][cY - 1] = true;
					}
					if (cX < h - 1 && cY > 0 && map[cX + 1][cY - 1] && !visited[cX + 1][cY - 1]) {
						q.push(make_pair(cX + 1, cY - 1)); visited[cX + 1][cY - 1] = true;
					}
					if (cX > 0 && cY < w - 1 && map[cX - 1][cY + 1] && !visited[cX - 1][cY + 1]) {
						q.push(make_pair(cX - 1, cY + 1)); visited[cX - 1][cY + 1] = true;
					}
					if (cX < h - 1 && cY < w - 1 && map[cX + 1][cY + 1] && !visited[cX + 1][cY + 1]) {
						q.push(make_pair(cX + 1, cY + 1)); visited[cX + 1][cY + 1] = true;
					}
					q.pop();
				}
				cnt++;
			}
		}
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int w, h;

	while (1) {
		cin >> w >> h;
		if (w == 0 && h == 0) break;
		init();
		getMap(w, h);
		cout << countIsland(w, h) << "\n";
	}
	return 0;
}
