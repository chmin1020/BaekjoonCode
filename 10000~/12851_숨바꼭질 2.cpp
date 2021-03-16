#include <iostream>
#include <queue>
using namespace std;
bool visited[100001];
int an = 100000, cnt = 0;

void push_check(queue<pair<int, int>> &q, int n, int ct, int target) {
	if (n == target) {
		if(cnt == 0) an = ct;
		cnt++;
	}
	if (n >= 0 && n <= 100000 && !visited[n])
		q.push(make_pair(n, ct)); 
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	queue<pair<int, int>> bfs;
	int cur, tar;

	cin >> cur >> tar;
	push_check(bfs, cur, 0, tar);
	while (!bfs.empty()) {
		if (bfs.front().second == an) break;
	
		push_check(bfs, bfs.front().first - 1, bfs.front().second + 1, tar);
		push_check(bfs, bfs.front().first + 1, bfs.front().second + 1, tar);
		push_check(bfs, bfs.front().first * 2, bfs.front().second + 1, tar);
		
		visited[bfs.front().first] = true;
		bfs.pop();
	}
	cout << an << '\n' << cnt << '\n';
	return 0;
}
