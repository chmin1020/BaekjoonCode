#include <iostream>
#include <cmath>
#include <functional>
#include <queue>
#include <vector>
using namespace std;

typedef pair<int, int> pInt;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, tmp;
	priority_queue<pInt, vector<pInt>, greater<pInt>> heap;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (tmp == 0) {
			if (heap.empty()) cout << "0\n";
			else {
				cout << heap.top().second << '\n';
				heap.pop();
			}
		}
		else 
			heap.push(make_pair(abs(tmp), tmp));
	}
	return 0;
}
