#include <iostream>
#include <string>
using namespace std;

int main() {
	int zeroS = 0, oneS = 0;
	char before;
	string s;

	cin >> s;
	before = s[0];
	if (before == '0') zeroS++;
	else oneS++;

	for (int i = 1; i < s.length(); i++) {
		if (s[i] != before) {
			if (s[i] == '0') zeroS++;
			else oneS++;
		}
		before = s[i];
	}
	if (zeroS < oneS) cout << zeroS << '\n';
	else cout << oneS << '\n';
	return 0;
}
