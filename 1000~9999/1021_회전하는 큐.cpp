#include <iostream>
#include <cstring>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	bool queue[51];
	int target[50], n, m, cur = 1, tpCnt = 0, cnt = 0;
	memset(queue, false, sizeof(queue));

	cin >> n >> m;
	for (int i = 0; i < m; i++)
		cin >> target[i];

	for (int i = 0; i < m; i++) {
		while (target[i] != cur) {
			if (!queue[cur]) tpCnt++;
			cur = (cur % n) + 1; 
		}
		cnt += ((tpCnt < (n - i) - tpCnt) ? tpCnt : (n - i) - tpCnt);
		queue[cur] = true; tpCnt = 0;
		while (target[i] != cur) cur = (cur % n) + 1;
	}
	cout << cnt << '\n';
	return 0;
}
