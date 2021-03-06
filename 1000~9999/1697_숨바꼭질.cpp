#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
bool visited[100001];

void push_check(queue<pair<int,int>> &q, int n, int target) {
	if (n >= 0 && n <= 100000 && !visited[n]) {
		q.push(make_pair(n, q.front().second + 1)); visited[n] = true;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(visited, false, sizeof(visited));
	queue<pair<int,int>> bfs;
	int cur, tar;

	cin >> cur >> tar;
	bfs.push(make_pair(cur, 0)); visited[cur] = true;
	while (1) {
		if (bfs.front().first == tar) break;
		push_check(bfs, bfs.front().first - 1, tar);
		push_check(bfs, bfs.front().first + 1, tar);
		push_check(bfs, bfs.front().first * 2, tar);
		bfs.pop();
	}
	cout << bfs.front().second << '\n';
	return 0;
}
