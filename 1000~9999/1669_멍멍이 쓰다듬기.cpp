#include <iostream>
#include <cmath>
using namespace std;

int main() {
	long long a, b;
	long long root;

	cin >> a >> b;
	root = (long long)sqrt(b - a);

	if (b - a == 0)
		cout << "0" << endl;
	else if (root*root == b - a)
		cout << root * 2 - 1 << endl;
	else if ((root + 1)*root >= b - a)
		cout << root * 2 << endl;
	else if ((root + 1)*(root + 1) >= b - a)
		cout << root * 2 + 1 << endl;
	return 0;
}
