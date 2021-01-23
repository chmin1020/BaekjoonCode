#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int matrix[101][101], size;

	cin >> size;
	for (int i = 1; i <= size; i++) //input
		for (int j = 1; j <= size; j++)
			cin >> matrix[i][j];

	for (int i = 1; i <= size; i++) //fw
		for (int j = 1; j <= size; j++) 
			for (int k = 1; k <= size; k++) 
				if (matrix[j][i] == 1 && matrix[i][k] == 1)
					matrix[j][k] = 1;

	for (int i = 1; i <= size; i++) { //output
		for (int j = 1; j <= size; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}
