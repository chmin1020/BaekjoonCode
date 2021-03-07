#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;
vector<int> graph[32001];
int front[32001];

void top_sort(int n) {
	queue<int> q;

	for (int i = 1; i <= n; i++)
		if (front[i] == 0) q.push(i);	

	while (!q.empty()) {
		for (int i = 0; i < graph[q.front()].size(); i++)
			if (--front[graph[q.front()][i]] == 0) q.push(graph[q.front()][i]);
		cout << q.front() << " ";
		q.pop();
	}
	cout << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m, st, en;
	memset(front, 0, sizeof(front));
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> st >> en;
		graph[st].push_back(en);
		front[en]++;
	}
	top_sort(n);
	return 0;
}
