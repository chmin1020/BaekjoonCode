#include <iostream>
#include <cmath>
using namespace std;
int r, c;

void draw_Z(int N, int x, int y, int startC) {
	if (N == 1) {
		int cnt = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (i + x == r && j + y == c) cout << startC + cnt << '\n';
				cnt++;
			}
		}
		return;
	}

	int next = (int)pow(2, N - 1);
	if ((x <= r && r < x + next) && (y <= c && c < y + next))
		draw_Z(N - 1, x, y, startC);
	else if ((x <= r && r < x + next) && (y + next <= c && c < y + 2 * next))
		draw_Z(N - 1, x, y + next, startC + (int)pow(4,N-1));
	else if ((x + next <= r && r < x + next * 2) && (y <= c && c < y + next))
		draw_Z(N - 1, x + next, y, startC + (int)pow(4, N - 1) *2);
	else
		draw_Z(N - 1, x + next, y + next, startC + (int)pow(4, N - 1)*3);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int N;
	cin >> N >> r >> c;
	draw_Z(N, 0, 0, 0);
	return 0;
}
