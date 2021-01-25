#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
int map[50][50], n, m, result = 1000000;
vector<pair<int, int>> housePos, chickenPos, chosen;
bool selected[13];

void dfs(int num, int index) {
	if (num == m) {
		int min, sum = 0;
		for (int i = 0; i < housePos.size(); i++) {
			min = 2000;
			for (int j = 0; j < m; j++)
				if (min > abs(chosen[j].first - housePos[i].first) + abs(chosen[j].second - housePos[i].second))
					min = abs(chosen[j].first - housePos[i].first) + abs(chosen[j].second - housePos[i].second);
			sum += min;
		}
		if (sum < result) result = sum;
		return;
	}

	for (int i = index + 1; i < chickenPos.size(); i++) {
		if (!selected[i]) {
			selected[i] = true; chosen.push_back(make_pair(chickenPos[i].first, chickenPos[i].second));
			dfs(num + 1, i);
			selected[i] = false; chosen.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> map[i][j];
			if (map[i][j] == 1) housePos.push_back(make_pair(i, j));
			if (map[i][j] == 2) chickenPos.push_back(make_pair(i, j));
		}
	}
	dfs(0, -1);
	cout << result << "\n";
	return 0;
}
