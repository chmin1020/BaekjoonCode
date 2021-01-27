#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
vector<pi> vertice[20001];
int shortest[20001];
bool visited[20001];
int v;

void sp(int start) {
	priority_queue<pi,vector<pi>,greater<pi>> q;
	int tmp;
	q.push(make_pair(0, start)); //가중치, 노드
	shortest[start] = 0;
	while (!q.empty()) {
		tmp = q.top().second;
		if (visited[tmp]) {
			q.pop();
			continue;
		}
		for (int i = 0; i < vertice[tmp].size(); i++) {
			shortest[vertice[tmp][i].first] = min(shortest[vertice[tmp][i].first], shortest[tmp] + vertice[tmp][i].second);
			q.push(make_pair(shortest[vertice[tmp][i].first], vertice[tmp][i].first));
		}
		visited[tmp] = true;
		q.pop();
		for (int i = 1; i <= v; i++) {
			if (shortest[i] == 10000000) cout << "INF ";
			else cout << shortest[i] << " ";
		}
		cout << "\n";
	}
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int e, start, de, ta, w;
	cin >> v >> e >> start;

	fill_n(shortest, 20001, 10000000);

	for (int i = 0; i < e; i++) {
		cin >> de >> ta >> w;
		vertice[de].push_back(make_pair(ta,w)); //도착 노드, 가중치
	}
	sp(start);
	for (int i = 1; i <= v; i++) {
		if (shortest[i] == 10000000) cout << "INF\n";
		else cout << shortest[i] << "\n";
	}
	return 0;
}
