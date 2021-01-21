#include <iostream>
#include <cstring>
#include <string>
#include <queue>
using namespace std;
queue<pair<string, int>> calc;
bool visited[10000];

string dslr(int origin, int target) {
	memset(visited, false, sizeof(visited));
	while (!calc.empty()) calc.pop();
	int cur, num; string tmp;

	calc.push(make_pair("",origin));
	while (1) {
		cur = calc.front().second;
	
		num = (cur * 2) % 10000;
		if (num == target) return calc.front().first+'D';
		if (!visited[num]) {
			calc.push(make_pair(calc.front().first + 'D', num)); visited[num] = true;
		}

		num = (cur == 0) ? 9999 : cur - 1;
		if (num == target) return calc.front().first + 'S';
		if (!visited[num]) {
			calc.push(make_pair(calc.front().first + 'S', num)); visited[num] = true;
		}

		tmp = to_string(cur);
		while (tmp.length() < 4) tmp.insert(tmp.begin(), '0');

		num = (tmp[0] - '0') + (tmp[1] - '0') * 1000 + (tmp[2] - '0') * 100 + (tmp[3] - '0') * 10;
		if (num == target) return calc.front().first + 'L';
		if (!visited[num]) {
			calc.push(make_pair(calc.front().first + 'L', num)); visited[num] = true;
		}

		num = (tmp[2] - '0') + (tmp[3] - '0') * 1000 + (tmp[0] - '0') * 100 + (tmp[1] - '0') * 10;
		if (num == target) return calc.front().first + 'R';
		if (!visited[num]) {
			calc.push(make_pair(calc.front().first + 'R', num)); visited[num] = true;
		}

		calc.pop();
	}
	return "error";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, origin, target;
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> origin >> target;
		cout << dslr(origin, target) << '\n';
	}
	return 0;
}
