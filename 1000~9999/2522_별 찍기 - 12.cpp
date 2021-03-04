#include <iostream>
#include <string>
using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++)
			cout << " ";
		for (int k = i; k >= 0 ; k--)
			cout << "*";
		putc('\n', stdout);
	}

	for (int i = 1; i < n; i++) {
		for (int j = 1; j <= i; j++)
			cout << " ";
		for (int k = n - i; k > 0; k--)
			cout << "*";
		putc('\n', stdout);
	}
}
