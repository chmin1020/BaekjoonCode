#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;

	cin >> n;
	vector<int> list(n), ordered(n);
	for (int i = 0; i < n; i++) {
		cin >> list[i];
		ordered[i] = list[i];
	}
	sort(ordered.begin(), ordered.end());
	ordered.erase(unique(ordered.begin(), ordered.end()),ordered.end());
	cout << lower_bound(ordered.begin(), ordered.end(), list[0]) - ordered.begin();
	for (int i = 1; i < n; i++)
		cout << " " << lower_bound(ordered.begin(), ordered.end(), list[i]) - ordered.begin();
	cout << '\n';
	return 0;
}
