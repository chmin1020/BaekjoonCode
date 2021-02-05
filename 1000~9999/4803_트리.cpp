#include <iostream>
#include <cstring>
using namespace std;
bool trees[501][501], visited[501];
int cnt, num = 1;
bool isCycle;

void dfs(int s, int n, int pre) {
	visited[s] = true;
	for (int i = 1; i <= n; i++) {
		if (trees[s][i] && visited[i] && pre != i)  isCycle = true;
		if (trees[s][i] && !visited[i]) dfs(i, n, s);
	}
}

void reset() {
	cnt = 0; isCycle = false;
	memset(trees, false, sizeof(trees));
	memset(visited, false, sizeof(visited));
}

void printResult() {
	cout << "Case " << num++ <<": ";
	if (cnt > 1) cout << "A forest of " << cnt << " trees.\n";
	else if (cnt == 1) cout << "There is one tree.\n";
	else cout << "No trees.\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m, s, e;

	while (1) {
		cin >> n >> m;
		if (n == 0 && m == 0) break;

		reset();
		for (int i = 0; i < m; i++) {
			cin >> s >> e;
			trees[s][e] = true;
			trees[e][s] = true;
		}
		for (int i = 1; i <= n; i++) {
			if(!visited[i]){
				dfs(i, n, 0);
				if (!isCycle) cnt++;
				isCycle = false;
			}
		}
		printResult();
	}
	return 0;
}
