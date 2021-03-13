#include <iostream>
#include <cstring>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;
int buildings[1001], pre[1001], dp[1001];
vector<int> graph[1001];

void reset() {
	memset(buildings, 0, sizeof(buildings));
	memset(pre, 0, sizeof(pre));
	memset(dp, 0, sizeof(dp));
	for (int i = 0; i <= 1001; i++)
		graph[i].clear();
}
int acm(int bCnt, int target) {
	queue<int> q;

	for (int i = 1; i <= bCnt; i++) {
		if (pre[i] == 0) {
			q.push(i);
			dp[i] = buildings[i];
		}
	}
	while (!q.empty()) {
		if (q.front() == target) break;
		for (int i = 0; i < graph[q.front()].size(); i++) {
			if (--pre[graph[q.front()][i]] == 0)
				q.push(graph[q.front()][i]);
			dp[graph[q.front()][i]] = max(dp[graph[q.front()][i]], dp[q.front()] + buildings[graph[q.front()][i]]);
		}
		q.pop();
	}
	return dp[target];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, bCnt, rCnt, tp1, tp2, target;
	
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		reset(); //reset		
		//input;
		cin >> bCnt >> rCnt;
		for (int j = 1; j <= bCnt; j++) {
			cin >> buildings[j];
			pre[j] = 0;
		}
		for (int j = 0; j < rCnt; j++) {
			cin >> tp1 >> tp2;
			graph[tp1].push_back(tp2);
			pre[tp2]++;
		}
		cin >> target;
		cout << acm(bCnt, target) << "\n"; 	//answer
	}
	return 0;
}
