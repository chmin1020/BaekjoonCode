#include <iostream>
#include <vector>
using namespace std;
typedef vector<vector<long long>> matrix;

matrix multiply(matrix a, matrix b, int size) {
	long long result = 0;
	matrix m(size, vector<long long>(size));

	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			for (int l = 0; l < size; l++)
				result += (a[i][l] * b[l][j]);
			m[i][j] = result % 1000;
			result = 0;
		}
	}
	return m;
}

matrix power(matrix mat, long long expo, int size) {
	matrix m(size, vector<long long>(size));

	for (int i = 0; i < size; i++)
		m[i][i] = 1;

	while (expo > 0) {
		if (expo % 2 == 1) {
			m = multiply(m, mat, size);
		}
		expo /= 2;
		mat = multiply(mat, mat, size);
	}
	return m;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	long long b;
	cin >> n >> b;
	matrix m(n, vector<long long>(n)), result(n, vector<long long>(n));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> m[i][j];
	result = power(m, b, n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << result[i][j] << " ";
		}
		cout << '\n';
	}
	return 0;
}
