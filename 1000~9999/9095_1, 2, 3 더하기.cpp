#include <iostream>
#include <cstring>
using namespace std;
int arr[12];

int cases(int n) {
	if (arr[n] == 0)
		arr[n] = cases(n - 3) + cases(n - 2) + cases(n - 1);
	return arr[n];
}

int main() {
	int n, tmp;
	memset(arr, 0, sizeof(arr));
	arr[1] = 1, arr[2] = 2, arr[3] = 4;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> tmp;
		cout << cases(tmp) << '\n';
	}
	return 0;
}c
