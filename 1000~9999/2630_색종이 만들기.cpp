#include <iostream>
using namespace std;
int paper[128][128], blue = 0, white = 0;
void check(int x, int y, int size);
void divide(int x, int y, int size);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> paper[i][j];
	check(0, 0, n);
	cout << white << '\n' << blue << '\n';
	return 0;
}
void check(int x, int y, int size) {
	int spe = paper[x][y];
	bool flag = false;

	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++)
			if (paper[i][j] != spe) {
				flag = true;
				break;
			}
	}
	if (flag) divide(x, y, size);
	else (spe == 0) ? white++ : blue++;
}

void divide(int x, int y, int size) {
	check(x, y, size / 2);
	check(x + size / 2, y, size / 2);
	check(x, y + size / 2, size / 2);
	check(x + size / 2, y + size / 2, size / 2);
}
