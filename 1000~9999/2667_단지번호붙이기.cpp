#include <iostream>
#include <string>
#include <queue>
#include <set>
using namespace std;
typedef pair<int, int> pi;
bool graph[101][101], visited[101][101];

int bfs(pi start, int size) {
	queue<pi> q;
	int tpx, tpy, cnt = 1;

	q.push(make_pair(start.first, start.second)); visited[start.first][start.second] = true;
	while (!q.empty()) {
		tpx = q.front().first; tpy = q.front().second;
		if (tpx > 0 && graph[tpx - 1][tpy] && !visited[tpx - 1][tpy]) {
			visited[tpx - 1][tpy] = true; 
			q.push(make_pair(tpx - 1, tpy)); cnt++;
		}
		if (tpx < size - 1 && graph[tpx + 1][tpy] && !visited[tpx + 1][tpy]) {
			visited[tpx + 1][tpy] = true;
			q.push(make_pair(tpx + 1, tpy)); cnt++;
		}
		if (tpy > 0 && graph[tpx][tpy - 1] && !visited[tpx][tpy - 1]) {
			visited[tpx][tpy - 1] = true;
			q.push(make_pair(tpx, tpy - 1)); cnt++;
		}
		if (tpy < size - 1 && graph[tpx][tpy + 1] && !visited[tpx][tpy + 1]) {
			visited[tpx][tpy + 1] = true;
			q.push(make_pair(tpx, tpy + 1)); cnt++;
		}
		q.pop();
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string input;
	multiset<int> result;

	int n, cnt = 0;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> input;
		for (int j = 0; j < n; j++)
			graph[i][j] = (input[j] == '1') ? true : false;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (graph[i][j] && !visited[i][j]) {
				result.insert(bfs(make_pair(i, j), n));
				cnt++;
			}
		}
	}
	cout << cnt << '\n';
	for (multiset<int>::iterator it = result.begin(); it != result.end(); it++)
		cout << *it << '\n';
	return 0;
}
