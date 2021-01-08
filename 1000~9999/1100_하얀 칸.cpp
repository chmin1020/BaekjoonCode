#include <iostream>
using namespace std;

int main() {
	char board[9];
	int cnt = 0;

	for (int i = 0; i < 8; i++) {
		cin >> board;
		for (int j = 0; j < 8; j++) {
			if (i % 2 == 0) {
				if (j % 2 == 0 && board[j] == 'F')
					cnt++;
			}
			else {
				if (j % 2 == 1 && board[j] == 'F')
					cnt++;
			}
		}
	}
	cout << cnt << endl;
	return 0;
}
