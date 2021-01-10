#include <iostream>
#include <string>
using namespace std;
int paper[128][128], blue = 0, white = 0;
void check(int x, int y, int size);
void divide(int x, int y, int size);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	string tmp;

	cin >> n;
	for (int i = 0; i < n; i++) {
			cin >> tmp;
			for (int j = 0; j < n; j++)
				paper[i][j] = tmp[j] - '0';
	}
	check(0, 0, n);
	putchar('\n');
	return 0;
}
void check(int x, int y, int size) {
	int spe = paper[x][y];
	bool flag = false;

	for (int i = x; i < x + size; i++) {
		for (int j = y; j < y + size; j++) {
			if (paper[i][j] != spe) {
				flag = true;
				break;
			}
		}
	}
	if (flag) {
		cout << "(";
		divide(x, y, size);
		cout << ")";
	}
	else (spe == 0) ? cout << "0" : cout << "1";
}

void divide(int x, int y, int size) {
	check(x, y, size / 2);
	check(x, y + size / 2, size / 2);
	check(x + size / 2, y, size / 2);
	check(x + size / 2, y + size / 2, size / 2);
}
