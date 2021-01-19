#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
bool graph[101][101];
bool visited[101];

int bfs(int start, int size) {
	queue<pair<int,int>> q;
	int result = 0;
	
	q.push(make_pair(start,0)); visited[start] = true;
	while (!q.empty()) {
		result += q.front().second;
		for (int i = 1; i <= size; i++) {
			if (graph[q.front().first][i] && !visited[i]) {
				q.push(make_pair(i, q.front().second + 1));
				visited[i] = true;
			}
		}
		q.pop();
	}
	return result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int people, relations, x, y, tmp;

	cin >> people >> relations;
	for (int i = 0; i < relations; i++) {
		cin >> x >> y;
		graph[x][y] = graph[y][x] = true;
	}
	x = bfs(1, people); y = 1;
	for (int i = 2; i <= people; i++) {
		memset(visited, false, sizeof(visited));
		tmp = bfs(i, people);
		if (x > tmp) {
			x = tmp;
			y = i;
		}
	}
	cout << y << '\n';
	return 0;
}
