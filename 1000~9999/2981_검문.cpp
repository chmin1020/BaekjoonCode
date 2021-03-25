#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int GCD(int n1, int n2) {
	if (n1 < n2) swap(n1, n2);
	return n2 ? GCD(n2, n1%n2) : n1;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, arr[100], gcd;
	vector<int> result;
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> arr[i];

	gcd = abs(arr[1] - arr[0]);
	for (int i = 2; i < n; i++) 
		gcd = GCD(gcd, abs(arr[i] - arr[i - 1]));


	for (int i = 2; i <= sqrt(gcd); i++) {
		if (gcd%i == 0) {
			result.push_back(i);
			result.push_back(gcd / i);
			if (i*i == gcd) result.pop_back();
		}
	}
	sort(result.begin(), result.end());
	for (int i = 0; i < result.size(); i++)
		cout << result[i] << " ";
	cout << gcd << '\n';
	return 0;
}
