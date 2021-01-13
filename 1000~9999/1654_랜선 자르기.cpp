#include <iostream>
using namespace std;
typedef long long ll;
ll k, n, cable[10000];

ll check(ll num) {
	ll sum = 0;
	for (int i = 0; i < k; i++)
		sum += (cable[i] / num);
	return sum;
}
ll find(ll max) {
	ll result = 0, sum = 0, left = 1, right = max, mid = 0;

	while (left <= right) {
		mid = (left + right) / 2;
		sum = check(mid);
		if (sum >= n) {
			if (result < mid) result = mid;
			left = mid + 1;
		}
		else right = mid - 1;
	}
	return result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	long long max = 0;
	cin >> k >> n;
	for (int i = 0; i < k; i++) {
		cin >> cable[i];
		max += cable[i];
	}
	max /= n;
	cout << find(max) << '\n';
	return 0;
}
