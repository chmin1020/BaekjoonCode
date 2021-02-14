#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(int a, int b) {
	return a > b;
}
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	vector<int> crane, box;
	int n, m, result = 0;

	cin >> n;
	crane.resize(n);
	for (int i = 0; i < n; i++)
		cin >> crane[i];
	sort(crane.begin(), crane.end(), cmp);

	cin >> m;
	box.resize(m);
	for (int i = 0; i < m; i++)
		cin >> box[i];
	sort(box.begin(), box.end(), cmp);

	if (box[0] > crane[0])
		result = -1;
	else {
		while (!box.empty()) {
			vector<int>::iterator it = box.begin();
			
			for (int i = 0; i < n; i++) {
				if (*it <= crane[i]) {
					it = box.erase(it);
				}
				else {
					it++;
					i--;
				}
				if (it == box.end()) break;
			}
			result++;
		}
	}
	cout << result << "\n";
	return 0;
}
