#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	queue<int> q;
	string order;
	int n, num;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> order;
		if (order == "push") {
			cin >> num;
			q.push(num);
		}
		else if (order == "pop") {
			if (q.empty()) cout << "-1\n";
			else {
				cout << q.front() << '\n';
				q.pop();
			}
		}
		else if (order == "size")
			cout << q.size() << '\n';
		else if (order == "empty")
			cout << q.empty() << '\n';
		else if (order == "front")
			(q.empty()) ? cout << "-1\n" : cout << q.front() << '\n';
		else
			(q.empty()) ? cout << "-1\n" : cout << q.back() << '\n';
	}
	return 0;
}
