#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
int farm[1000][1000], m, n, notR = 0;
bool checked[1000][1000];
queue<pair<int, int>> tomato;

int ripe(int day, int work) {
	int nw = 0, tx, ty;

	for (int i = 0; i < work; i++) {
		tx = tomato.front().first; ty = tomato.front().second;
		checked[tx][ty] = true;

		if (tx > 0 && farm[tx - 1][ty] == 0) {
			farm[tx - 1][ty] = 1;
			tomato.push(make_pair(tx - 1, ty)); nw++; notR--;
		}
		if (tx < n - 1 && farm[tx + 1][ty] == 0) {
			farm[tx + 1][ty] = 1;
			tomato.push(make_pair(tx + 1, ty)); nw++; notR--;
		}
		if (ty > 0 && farm[tx][ty - 1] == 0) {
			farm[tx][ty - 1] = 1;
			tomato.push(make_pair(tx, ty - 1)); nw++; notR--;
		}
		if (ty < m - 1 && farm[tx][ty + 1] == 0) {
			farm[tx][ty + 1] = 1;
			tomato.push(make_pair(tx, ty + 1)); nw++; notR--;
		}
		tomato.pop();
	}
	return (!tomato.empty()) ? ripe(day + 1, nw) : day;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(farm, 0, sizeof(farm));
	int work = 0, ans;

	cin >> m >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> farm[i][j];
			if (farm[i][j] == 0) notR++;
			if (farm[i][j] == 1) {
				work++;
				tomato.push(make_pair(i, j));
				checked[i][j] = true;
			}
		}
	}
	ans = ripe(0,work);
	(notR != 0)? cout << "-1\n" : cout << ans << '\n';
	return 0;
}
