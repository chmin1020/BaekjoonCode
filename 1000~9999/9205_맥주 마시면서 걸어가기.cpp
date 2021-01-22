#include <iostream>
#include <cmath>
#include <cstring>
#include <string>
#include <queue>
#include <vector>
using namespace std;
vector<pair<int, int>> pos;
queue<pair<int, int>> bfs;
bool visited[100];

string check(int size, pair<int,int> start, pair<int,int> des) {
	while (!bfs.empty()) bfs.pop();
	pair<int, int> front;
	if (abs(start.first - des.first) + abs(start.second - des.second) <= 1000) return "happy";
	bfs.push(start);
	while (!bfs.empty()) {
		front = bfs.front();
		for (int i = 0; i < size; i++) {
			if (!visited[i] && abs(pos[i].first - front.first) + abs(pos[i].second - front.second) <= 1000) {
				if (abs(pos[i].first - des.first) + abs(pos[i].second - des.second) <= 1000) return "happy";
				bfs.push(pos[i]);
				visited[i] = true;
			}
		}
		bfs.pop();
	}
	return "sad";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, conCnt;
	pair<int, int> tmp, start;

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> conCnt;
		pos.clear(); memset(visited, false, sizeof(visited));
		cin >> start.first >> start.second;
		for (int j = 0; j < conCnt; j++) {
			cin >> tmp.first >> tmp.second;
			pos.push_back(tmp);
		}
		cin >> tmp.first >> tmp.second;
		cout << check(conCnt, start, tmp) << '\n';
	}
	return 0;
}
