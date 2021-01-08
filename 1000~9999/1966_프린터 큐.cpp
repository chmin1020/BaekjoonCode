#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	queue<int> qu;
	int cases, n, target, cur, cnt = 1;
	int rank[100];

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> n >> target;
		for (int i = 0; i < n; i++) {
			cin >> rank[i]; qu.push(rank[i]);
		}
		sort(rank, rank + n);

		cur = n - 1;
		while (1) {
			if (rank[cur] == qu.front()) {
				if (target == 0) break;
				qu.pop(); cnt++;
				cur--; target--;
			}
			else {
				(target == 0) ? target = cur : target--;
				qu.push(qu.front());
				qu.pop();
			}
		}
		cout << cnt << '\n'; cnt = 1;
		while (!qu.empty()) qu.pop();
	}
	return 0;
}
