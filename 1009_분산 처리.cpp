#include <iostream>
using namespace std;

int main() {
	int test;
	int a, b, calTmp;

	cin >> test;

	for (int i = 0; i < test; i++) {
		cin >> a >> b;
		calTmp = 1;
		for (int j = 0; j < b; j++) {
			calTmp *= a;
			calTmp = calTmp % 10;
		}
		if (calTmp == 0) cout << "10" << endl;
		else cout << calTmp << endl;
	}
	return 0;
}
