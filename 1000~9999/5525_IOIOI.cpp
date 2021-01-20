#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string input;
	int n, len, cnt = 0, sct = 0;
	bool flag = true;

	cin >> n >> len >> input;
	for (int i = 0; i < len; i++) {
		if (input[i] == 'I' && flag) {
			sct++; flag = false;
			if (i != len - 1) continue;
		}
		else if (input[i] == 'O' && !flag) {
			sct++; flag = true;
			if (i != len - 1) continue;
		}
		if (sct >= 2 * n + 1) {
			cnt++;
			sct -= (2 * n + 1);
			cnt += (sct / 2);
		}
		sct = 0; 
		(input[i] == 'I')? sct++ : flag = true;
	}
	cout << cnt << '\n';
	return 0;
}
