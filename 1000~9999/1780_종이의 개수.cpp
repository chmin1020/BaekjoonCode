#include <iostream>
using namespace std;
int paper[6561][6561], m_one = 0, zero = 0, one = 0;
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
	cout << m_one << '\n' << zero << '\n' << one << '\n';
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
	if (flag) 
		divide(x, y, size);
	else {
		switch (spe){
			case -1: m_one++; break;
			case 0: zero++; break;
			default: one++;
		}
	}
}

void divide(int x, int y, int size) {
	check(x, y, size / 3);
	check(x, y + size / 3, size / 3);
	check(x, y + 2 * (size / 3), size / 3);
	check(x + size / 3, y, size / 3);
	check(x + size / 3, y + size / 3, size / 3);
	check(x + size / 3, y + 2* (size / 3), size / 3);
	check(x + 2 * (size / 3), y, size / 3);
	check(x + 2 * (size / 3), y + size / 3, size / 3);
	check(x + 2 * (size / 3), y + 2 * (size / 3), size / 3);
}
