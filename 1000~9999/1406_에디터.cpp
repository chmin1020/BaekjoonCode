#include <iostream>
#include <stack>
#include <string>
using namespace std;

void work(string str, int inst) {
	stack<char> ans, tmp;
	char op;

	for (int i = 0; i < str.length(); i++)
		ans.push(str[i]);
	for (int i = 0; i < inst; i++) {
		cin >> op;
		
		if (op == 'L') {
			if (ans.empty()) continue;
			tmp.push(ans.top());
			ans.pop();
		}
		else if (op == 'D') {
			if (tmp.empty()) continue;
			ans.push(tmp.top());
			tmp.pop();
		}
		else if (op == 'B') {
			if (ans.empty()) continue;
			ans.pop();
		}
		else {
			cin >> op;
			ans.push(op);
		}
	}

	while (!tmp.empty()) {
		ans.push(tmp.top());
		tmp.pop();
	}
	str.clear();
	while (!ans.empty()) {
		str.push_back(ans.top());
		ans.pop();
	}
	for (int i = str.length() - 1; i >= 0; i--)
		cout << str[i];
	cout << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string str;
	int inst;

	cin >> str >> inst;
	work(str, inst);
	return 0;
}
