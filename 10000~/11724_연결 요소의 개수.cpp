#include <iostream>
#include <cstring>
using namespace std;
bool vertice[1001][1001], visited[1001];

void dfs(int v, int size) {
	visited[v] = true;
	for (int i = 1; i <= size; i++)
		if (vertice[v][i] && !visited[i]) dfs(i, size);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(vertice, false, sizeof(vertice));
	memset(visited, false, sizeof(visited));
	int v, e, v1, v2, cnt = 0;

	cin >> v >> e;
	for (int i = 0; i < e; i++) {
		cin >> v1 >> v2;
		vertice[v1][v2] = vertice[v2][v1] = true;
	}
	for (int i = 1; i <= v; i++) {
		if (!visited[i]) {
			dfs(i, v); cnt++;
		}
	}
	cout << cnt << '\n';
	return 0;
}
