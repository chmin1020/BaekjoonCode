#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string pos;
	int cur = 0, cnt = 0;

	cin >> pos;
	for (int i = 0; i < pos.length(); i++) {
		if (pos[i] == '(') {
			if (pos[i + 1] == ')') {
				cnt += cur;
				i++; continue;
			}
			cur++;
		}
		else {
			cur--; cnt++;
		}
	}
	cout << cnt << "\n";
	return 0;
}
