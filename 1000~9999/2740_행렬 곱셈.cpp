#include <iostream>
using namespace std;
int matrixA[100][100], matrixB[100][100];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m, k, result = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> matrixA[i][j];
	cin >> m >> k;
	for (int i = 0; i < m; i++)
		for (int j = 0; j < k; j++)
			cin >> matrixB[i][j];

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			for (int l = 0; l < m; l++) {
				result += matrixA[i][l] * matrixB[l][j];
			}
			cout << result << " ";
			result = 0;
		}
		putchar('\n');
	}

	return 0;
}
