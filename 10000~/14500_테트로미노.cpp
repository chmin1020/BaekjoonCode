#include <iostream>
using namespace std;
bool visited[500][500];
int paper[500][500];
int res = -1, n, m;

void dfs(int num, int sum, int x, int y) {
	if (num == 4) {
		if (sum > res) res = sum;
		return;
	}
	visited[x][y] = true;

	if (x < n - 1 && !visited[x + 1][y])
		dfs(num + 1, sum + paper[x + 1][y], x + 1, y);
	if (y > 0 && !visited[x][y - 1])
		dfs(num + 1, sum + paper[x][y - 1], x, y - 1);
	if (y < m - 1 && !visited[x][y + 1])
		dfs(num + 1, sum + paper[x][y + 1], x, y + 1);

	visited[x][y] = false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int sum;

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> paper[i][j];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			dfs(1, paper[i][j], i, j);

			if (i > 0 && i < n - 1) {
				sum = paper[i - 1][j] + paper[i][j] + paper[i + 1][j];
				if (j > 0)
					if(sum + paper[i][j - 1] > res) res = sum + paper[i][j - 1];
				if (j < m - 1)
					if (sum + paper[i][j + 1] > res) res = sum + paper[i][j + 1];
			}
			if (j > 0 && j < m - 1) {
				sum = paper[i][j - 1] + paper[i][j] + paper[i][j + 1];
				if (i > 0)
					if (sum + paper[i - 1][j] > res) res = sum + paper[i - 1][j];
				if (i < n - 1)
					if (sum + paper[i + 1][j] > res) res = sum + paper[i + 1][j];
			}
		}
	}
	cout << res << '\n';
	return 0;
}
