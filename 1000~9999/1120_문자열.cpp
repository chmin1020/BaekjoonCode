#include <iostream>
#include <string>
using namespace std;

int main() {
	string a, b;
	int min = 51, cnt = 0;
	cin >> a >> b;

	for (int i = 0; i < (signed int)(b.length() - a.length()) + 1; i++) {
		for (int j = i; j < (signed int)a.length() + i; j++)
			if (a[j - i] != b[j])  cnt++;
		if (cnt < min)  min = cnt;
		cnt = 0;
	}
	cout << min << endl;
	return 0;
}
