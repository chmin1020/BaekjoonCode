#include <iostream>
using namespace std;

int main() {
	int n, f;

	cin >> n >> f;

	n -= (n % 100);

	if (n%f == 0)
		cout << "00" << endl;
	else if (f - (n%f) < 10)
		cout << "0" << f- (n%f) << endl;
	else
		cout << f - (n%f) << endl;

	return 0;
}
