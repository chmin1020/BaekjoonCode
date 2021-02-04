#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
#define INF 1000000000
using namespace std;
vector<pair<pair<int, int>,int>> path;

bool check(int n) {
	int shortest[501];
	int start, end, time;

	for (int i = 0; i <= 500; i++) shortest[i] = INF;
	memset(shortest, -1, sizeof(shortest));

	shortest[1] = 0;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < path.size(); j++) {
			start = path[j].first.first;
			end = path[j].first.second;
			time = path[j].second;

			if (shortest[start] == INF) continue;
			shortest[end] = min(shortest[end], shortest[start] + time);
		}
	}
	for (int j = 0; j < path.size(); j++) {
		start = path[j].first.first;
		end = path[j].first.second;
		time = path[j].second;

		if (shortest[start] == INF) continue;
		if (shortest[end] > shortest[start] + time)
			return true;
	}
	return false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, n, m, w, s, e, t;

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		path.clear();
		cin >> n >> m >> w;
		for (int j = 0; j < m; j++) {
			cin >> s >> e >> t;
			path.push_back(make_pair(make_pair(s, e), t));
			path.push_back(make_pair(make_pair(e, s), t));
		}
		for (int j = 0; j < w; j++) {
			cin >> s >> e >> t;
			path.push_back(make_pair(make_pair(s, e), -t));
		}
		if(check(n)) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}
