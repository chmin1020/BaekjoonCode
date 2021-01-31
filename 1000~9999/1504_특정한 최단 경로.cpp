#include <iostream>
#include <vector>
#include <functional>
#include <algorithm>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
vector<pi> road[200001];
bool visited[801];
pi poss[3];

pi dijkstra(int start, int des1, int des2) {
	priority_queue<pi, vector<pi>, greater<pi>> q;
	int shortest[801], tmp;
	fill_n(visited, 801, false);
	fill_n(shortest, 801, 1000000000);
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
	return make_pair(shortest[des1], shortest[des2]);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, e, st1, st2, dis;

	cin >> n >> e;
	for (int i = 0; i < e; i++) {
		cin >> st1 >> st2 >> dis;
		road[st1].push_back(make_pair(dis, st2));
		road[st2].push_back(make_pair(dis, st1));
	}
	cin >> st1 >> st2;

	bool flag = true;
	poss[0] = dijkstra(1, st1, st2);
	poss[1] = dijkstra(st1, st2, n);
	poss[2] = dijkstra(st2, st1, n);
	for (int i = 0; i < 2; i++)
		if (poss[i].first == 1000000000 || poss[i].second == 1000000000)
			flag = false;
	if (flag) cout << min(poss[0].first + poss[1].first + poss[2].second, poss[0].second + poss[1].second + poss[2].first) << "\n";
	else cout << "-1\n";
	return 0;
}
