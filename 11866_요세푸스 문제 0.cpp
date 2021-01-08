#include <iostream>
#include <cstring>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	bool queue[1001];
	int n, k, cur = 0, cnt = 0, fullCnt = 1;
	memset(queue, false, sizeof(queue));

	cin >> n >> k;
	cur = k; queue[cur] = true;
	cout << "<" << cur;
	while (fullCnt != n) {
		cur++;
		if (cur > n) cur -= n;
		if (queue[cur]) continue;
		cnt++;
		if (cnt == k) {
			cout << ", " << cur;
			queue[cur] = true;
			cnt = 0; fullCnt++;
		}
	}
	cout << ">\n";
	return 0;
}1
