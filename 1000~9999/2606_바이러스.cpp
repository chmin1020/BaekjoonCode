#include <iostream>
using namespace std;
bool network[101][101], infected[101];
int cnt = 0;

void worm(int n, int com) {
	for (int i = 1; i <= n; i++) {
		if (network[com][i] && !infected[i]) {
			infected[i] = true; cnt++;
			worm(n, i);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, pair, tp1, tp2;

	cin >> n >> pair;
	for (int i = 0; i < pair; i++) {
		cin >> tp1 >> tp2;
		network[tp1][tp2] = network[tp2][tp1] = true;
	}
	infected[1] = true;
	worm(n, 1);
	cout << cnt << '\n';
	return 0;
}
