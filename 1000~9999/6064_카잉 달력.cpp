#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, m, n, x, y, ty, cnt;
	
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		ty = cnt = 0;
		cin >> m >> n >> x >> y;
		while (1) {
			ty += x; cnt += x;
			if (ty%n == 0) ty = n;
			else ty %= n;
			if (ty == y) {
				cout << cnt << '\n';
				break;
			}
			ty += (m - x); cnt += (m - x);
			if(ty%n == 0) ty = n;
			else ty %= n;
			if (ty == n) {
				cout << "-1\n";
				break;
			}
		}
	}
	return 0;
}
