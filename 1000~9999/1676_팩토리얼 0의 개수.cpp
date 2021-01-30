#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, two = 0, five = 0, tmp;
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		tmp = i;
		while (tmp % 2 == 0) {
			tmp /= 2; two++;
		}
		while (tmp % 5 == 0) {
			tmp /= 5; five++;
		}
	}
	if(two>five) cout << five << '\n';
	else cout << two << '\n';
	return 0;
}
