#include <iostream>
#include <queue>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	queue<int> qu;
	int n;
	bool repush = false;
	
	cin >> n;
	for (int i = 1; i <= n; i++) qu.push(i);
	while (qu.size() > 1) {
		if (repush) qu.push(qu.front());
		qu.pop(); repush = !repush;
	}
	cout << qu.front() << '\n';
	return 0;
}
