#include <iostream>
#include <algorithm>
#include <vector>
#include <functional>
#include <queue>
using namespace std;
vector<pair<int, int>> cities[1001];
bool visited[1001];
int n, m;

int dijkstra(int start, int des) {
	priority_queue<pair<int, int>,vector<pair<int, int>>,greater<pair<int,int>>> q;
	int shortest[1001];
	vector<pair<int, int>> tmp;
	fill_n(shortest, 1001, 1500000000);
	shortest[start] = 0;
	q.push(make_pair(0, start));

	while (!q.empty()) {
		if (!visited[q.top().second]){
			tmp = cities[q.top().second];
			for (int i = 0; i < (signed int)tmp.size(); i++) {
				if (!visited[tmp[i].second]) {
					shortest[tmp[i].second] = min(shortest[tmp[i].second], shortest[q.top().second] + tmp[i].first);
					q.push(make_pair(shortest[tmp[i].second], tmp[i].second));
				}
			}
		}
		visited[q.top().second] = true;
		q.pop();
	}
	return shortest[des];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int s, f, w, start, des;

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> s >> f >> w;
		cities[s].push_back(make_pair(w, f)); //비용, 노드 순
	}
	cin >> start >> des;
	cout << dijkstra(start, des) << "\n";
	return 0;
}
