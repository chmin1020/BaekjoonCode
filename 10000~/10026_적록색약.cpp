#include <iostream>
#include <cstring>
#include <string>
#include <queue>
using namespace std;
char pic[101][101];
bool visited[101][101];

int res(int size, bool weak) {
	queue<pair<pair<int, int>, char>> bfs;
	memset(visited, false, sizeof(visited));
	int tpx, tpy, cnt = 0;

	for (int i = 1; i <= size; i++) {
		for (int j = 1; j <= size; j++) {
			if (!visited[i][j]) {
				bfs.push(make_pair(make_pair(i, j), pic[i][j]));
				visited[i][j] = true;
				do {
					tpx = bfs.front().first.first; tpy = bfs.front().first.second;

					if (tpx > 1 && !visited[tpx - 1][tpy]) {
						if ((weak && ((pic[tpx - 1][tpy] != 'B' && bfs.front().second != 'B') || (pic[tpx - 1][tpy] == 'B' && bfs.front().second == 'B'))) || (!weak && pic[tpx - 1][tpy] == bfs.front().second)) {
							bfs.push(make_pair(make_pair(tpx - 1, tpy), pic[tpx - 1][tpy]));
							visited[tpx - 1][tpy] = true;
						}
					}
					if (tpx < size && !visited[tpx + 1][tpy]) {
						if ((weak && ((pic[tpx + 1][tpy] != 'B' && bfs.front().second != 'B') || (pic[tpx + 1][tpy] == 'B' && bfs.front().second == 'B'))) || (!weak && pic[tpx + 1][tpy] == bfs.front().second)) {
							bfs.push(make_pair(make_pair(tpx + 1, tpy), pic[tpx + 1][tpy]));
							visited[tpx + 1][tpy] = true;
						}
					}
					if (tpy > 1 && !visited[tpx][tpy - 1]) {
						if ((weak && ((pic[tpx][tpy - 1] != 'B' && bfs.front().second != 'B') || (pic[tpx][tpy - 1] == 'B' && bfs.front().second == 'B'))) || (!weak && pic[tpx][tpy - 1] == bfs.front().second)) {
							bfs.push(make_pair(make_pair(tpx, tpy - 1), pic[tpx][tpy - 1]));
							visited[tpx][tpy - 1] = true;
						}
					}
					if (tpy < size && !visited[tpx][tpy + 1]) {
						if ((weak && ((pic[tpx][tpy + 1] != 'B' && bfs.front().second != 'B') || (pic[tpx][tpy + 1] == 'B' && bfs.front().second == 'B'))) || (!weak && pic[tpx][tpy + 1] == bfs.front().second)) {
							bfs.push(make_pair(make_pair(tpx, tpy + 1), pic[tpx][tpy + 1]));
							visited[tpx][tpy + 1] = true;
						}
					}
					bfs.pop();
				} while (!bfs.empty());
				cnt++;
			}
		}
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int size;
	string input;
	cin >> size;
	for (int i = 1; i <= size; i++) {
		cin >> input;
		for (int j = 1; j <= size; j++)
			pic[i][j] = input[j - 1];
	}
	cout << res(size, false) << ' ' << res(size, true) << '\n';
	return 0;
}
