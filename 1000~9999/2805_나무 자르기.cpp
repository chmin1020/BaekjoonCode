#include <iostream>
using namespace std;
typedef long long ll;
ll n, m, tree[1000000];

ll check(ll h) {
	ll sum = 0;
	for (int i = 0; i < n; i++)
		if(tree[i] > h)
		sum += (tree[i] - h);
	return sum;
}
ll find(ll max) {
	ll result = 0, sum = 0, left = 1, right = max, mid;

	while (left <= right) {
		mid = (left + right) / 2;
		sum = check(mid);
		if (sum >= m){
			left = mid + 1;
			if(result < mid) result = mid;
		}
		else if (sum < m) right = mid - 1;
	}
	return result;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	long long max = 0;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> tree[i];
		if (tree[i] > max) max = tree[i];
	}
	cout << find(max - 1) << '\n';
	return 0;
}
