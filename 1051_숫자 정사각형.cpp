#include <iostream>
#include <string>
using namespace std;

int main() {
	int board[51][51];
	int n, m, start;
	int tmp;
	string str;
	bool flag = false;

	cin >> n >> m;
	start = (n > m) ? m : n;

	for (int i = 0; i < n; ++i)
	{
		cin >> str;
		for (int j = 0; j < m; ++j)
		{
			board[i][j] = str[j] - '0';
		}
	}


	while (start != 1) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i + (start - 1) < n && j + (start - 1) < m){
					if (board[i][j] == board[i][j + (start - 1)] && board[i][j] == board[i + (start - 1)][j] && board[i][j] == board[i + (start - 1)][j + (start - 1)]) {
						flag = true;
						cout << start*start << "\n";
						break;
					}
				}
			}
			if (flag) break;
		}
		if (flag) break;
		start--;
	}
	
	if(!flag) cout << 1 << '\n';

	return 0;
}
