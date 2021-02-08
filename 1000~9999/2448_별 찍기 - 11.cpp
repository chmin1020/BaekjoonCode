#include <iostream>
#include <cmath>
using namespace std;
bool print[3100][6200];

void makeStar(int startX, int startY, int n) {
	if (n == 0) {
		print[startX][startY] = true;
		print[startX + 1][startY - 1] = print[startX + 1][startY + 1] = true;
		for (int i = startY - 2; i <= startY + 2; i++)
			print[startX + 2][i] = true;
		return;
	}

	makeStar(startX, startY, n - 1);
	makeStar(startX + 3 * (int)pow(2, n - 1), startY - 3 * (int)pow(2, n - 1), n - 1);
	makeStar(startX + 3 * (int)pow(2, n - 1), startY + 3 * (int)pow(2, n - 1), n - 1);
}

void printAnswer(int size) {
	for (int i = 1; i <= size; i++) {
		for (int j = 1; j <= size * 2 - 1; j++) {
			if (print[i][j]) cout << "*";
			else cout << " ";
		}
		cout << "\n";
	} 
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int size, tmp, n = 0;

	cin >> size;
	tmp = size / 3;
	while (tmp != 1) {
		tmp /= 2; n++;
	}
	makeStar(1, size, n);
	printAnswer(size);
	return 0;
}
