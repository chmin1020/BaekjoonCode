#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;
int nums[8], m, n;
vector<int> path;
bool visited[8];

void backTracking(int cnt) {
	if (cnt == m) {
		for (int i = 0; i < path.size(); i++)
			cout << path[i] << " ";
		cout << '\n'; return;
	}
	for (int i = 0; i < n; i++) {
		if (!visited[i]) {
			visited[i] = true; path.push_back(nums[i]);
			backTracking(cnt + 1);
			visited[i] = false;  path.pop_back();
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(visited, false, sizeof(visited));
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> nums[i];
	sort(nums, nums + n);
	backTracking(0);
	return 0;
}
