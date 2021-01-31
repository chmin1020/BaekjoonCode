#include <iostream>
#include <vector>
#include <functional>
#include <algorithm>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
vector<pi> road[1001];
bool visited[1001];

int dijkstra(int start, int des) {
	priority_queue<pi, vector<pi>, greater<pi>> q;
	int shortest[1001], tmp;
	fill_n(visited, 1001, false);
	fill_n(shortest, 1001, 1000000000);
	shortest[start] = 0;
	q.push(make_pair(0, start));
	while (!q.empty()) {
		tmp = q.top().second;
		if (!visited[tmp]) {
			for (int i = 0; i < road[tmp].size(); i++) {
				shortest[road[tmp][i].second] = min(shortest[road[tmp][i].second], shortest[tmp] + road[tmp][i].first);
				if (!visited[road[tmp][i].second])
					q.push(make_pair(shortest[road[tmp][i].second], road[tmp][i].second));
			}
			visited[tmp] = true;
		}
		q.pop();
	}
	return shortest[des];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m, x, begin, end, time;

	cin >> n >> m >> x;
	for (int i = 0; i < m; i++) {
		cin >> begin >> end >> time;
		road[begin].push_back(make_pair(time, end));
	}
	int ans = -1;
	for (int i = 1; i <= n; i++)
		if (x != i) ans = max(ans, dijkstra(i, x) + dijkstra(x, i));
	cout << ans << "\n";
	return 0;
}
