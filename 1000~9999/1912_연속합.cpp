#include <iostream>
#define MAX(a,b) (a>b)?a:b
using namespace std;
int seq[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, tmp = 0, max = -1001;
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> seq[i];

	seq[0] = 0;
	for (int i = 1; i <= n; i++) {
		tmp = MAX(tmp + seq[i], seq[i]);
		if (max < tmp) max = tmp;
	}
	cout << max << '\n';
	return 0;
}
