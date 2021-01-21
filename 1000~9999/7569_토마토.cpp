#include <iostream>
#include <cstring>
#include <queue>
using namespace std;
int farm[100][100][100], m, n, h, notR = 0;
bool checked[100][100][100];
queue<pair<int,pair<int, int>>> tomato;

int ripe(int day, int work) {
	int nw = 0, tx, ty, tz;

	for (int i = 0; i < work; i++) {
		tx = tomato.front().second.first; ty = tomato.front().second.second;
		tz = tomato.front().first;
		checked[tz][tx][ty] = true;

		if (tx > 0 && farm[tz][tx - 1][ty] == 0) {
			farm[tz][tx - 1][ty] = 1;
			tomato.push(make_pair(tz, make_pair(tx - 1, ty))); nw++; notR--;
		}
		if (tx < n - 1 && farm[tz][tx + 1][ty] == 0) {
			farm[tz][tx + 1][ty] = 1;
			tomato.push(make_pair(tz, make_pair(tx + 1, ty))); nw++; notR--;
		}
		if (ty > 0 && farm[tz][tx][ty - 1] == 0) {
			farm[tz][tx][ty - 1] = 1;
			tomato.push(make_pair(tz, make_pair(tx, ty - 1))); nw++; notR--;
		}
		if (ty < m - 1 && farm[tz][tx][ty + 1] == 0) {
			farm[tz][tx][ty + 1] = 1;
			tomato.push(make_pair(tz, make_pair(tx, ty + 1))); nw++; notR--;
		}
		if (tz > 0 && farm[tz - 1][tx][ty] == 0) {
			farm[tz - 1][tx][ty] = 1;
			tomato.push(make_pair(tz - 1, make_pair(tx, ty))); nw++; notR--;
		}
		if (tz < h - 1 && farm[tz + 1][tx][ty] == 0) {
			farm[tz + 1][tx][ty] = 1;
			tomato.push(make_pair(tz + 1, make_pair(tx, ty))); nw++; notR--;
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

	cin >> m >> n >> h;
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				cin >> farm[i][j][k];
				if (farm[i][j][k] == 0) notR++;
				if (farm[i][j][k] == 1) {
					work++;
					tomato.push(make_pair(i, make_pair(j, k)));
					checked[i][j][k] = true;
				}
			}
		}
	}
	ans = ripe(0, work);
	(notR != 0) ? cout << "-1\n" : cout << ans << '\n';
	return 0;
}
