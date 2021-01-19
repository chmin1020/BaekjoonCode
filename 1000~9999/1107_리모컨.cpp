#include <iostream>
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	bool flag;
	int target, ans, brokenCnt;

	cin >> target >> brokenCnt;
	vector<int> brokenBtn(brokenCnt);
	for (int i = 0; i < brokenCnt; i++) {
		cin >> brokenBtn[i];
	}
	ans = abs(target - 100);
	if (brokenCnt != 10) {
		for (int i = 0;; i++) {
			string tmp = to_string(i);
			flag = true;

			for (int j = 0; j < brokenCnt; j++) {
				if (tmp.find(brokenBtn[j] + '0') != string::npos) {
					flag = false; break;
				}
			}

			if (flag) ans = min(ans, abs(i - target) + (int)tmp.length());
			if (target < i && ans < abs(i - target) + (int)tmp.length())
				break;
		}
	}

	cout << ans << '\n';
	return 0;
}
