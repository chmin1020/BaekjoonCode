#include <iostream>
#include <string>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
bool graph[101][101], visited[101][101];

int bfs(int maxX, int maxY) {
	queue<pair<pi,int>> q;
	int tpx, tpy;

	q.push(make_pair(make_pair(1,1),0)); visited[1][1] = true;
	while (!q.empty()) {
		tpx = q.front().first.first; tpy = q.front().first.second;
		if (tpx == maxX && tpy == maxY) return q.front().second + 1;

		if (tpx > 1 && graph[tpx - 1][tpy] && !visited[tpx - 1][tpy]) {
			visited[tpx - 1][tpy] = true; 
			q.push(make_pair(make_pair(tpx - 1, tpy), q.front().second + 1));
		}
		if (tpx < maxX && graph[tpx + 1][tpy] && !visited[tpx + 1][tpy]) {
			visited[tpx + 1][tpy] = true;
			q.push(make_pair(make_pair(tpx + 1, tpy), q.front().second + 1));
		}
		if (tpy > 1 && graph[tpx][tpy - 1] && !visited[tpx][tpy - 1]) {
			visited[tpx][tpy - 1] = true;
			q.push(make_pair(make_pair(tpx, tpy - 1), q.front().second + 1));
		}
		if (tpy < maxY && graph[tpx][tpy + 1] && !visited[tpx][tpy + 1]) {
			visited[tpx][tpy + 1] = true;
			q.push(make_pair(make_pair(tpx, tpy + 1), q.front().second + 1));
		}
		q.pop();
	}
	return -1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string input;
	int n, m;

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		cin >> input;
		for (int j = 0; j < m; j++)
			graph[i][j + 1] = (input[j] == '1') ? true : false;
	}
	cout << bfs(n, m) << '\n';
	return 0;
}
