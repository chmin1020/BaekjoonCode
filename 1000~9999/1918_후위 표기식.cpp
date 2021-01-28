#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	stack<char> op;
	string notation;

	cin >> notation;
	for (int i = 0; i < notation.length(); i++) {
		if (notation[i] >= 'A' && notation[i] <= 'Z')
			cout << notation[i];
		else {
			if (notation[i] == '(') op.push(notation[i]);
			else if(notation[i] == ')'){
				while (op.top() != '(') {
					cout << op.top();
					op.pop();
				}
				op.pop();
			}
			else {
				if (notation[i] == '+' || notation[i] == '-') {
					while (!op.empty() && op.top() != '(') {
						cout << op.top();
						op.pop();
					}
				}
				else if (notation[i] == '*' || notation[i] == '/') {
					while (!op.empty() && (op.top() == '*' || op.top() == '/')) {
						cout << op.top();
						op.pop();
					}
				}
				op.push(notation[i]);
			}
		}
	}
	while (!op.empty()) {
		cout << op.top();
		op.pop();
	}
	cout << "\n";
	return 0;
}
