#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	bool bits[21];
	string order;
	int tar, n;
	memset(bits, false, sizeof(bits));

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> order;
		if (order == "all" || order == "empty")
			(order == "all")? memset(bits, true, sizeof(bits)): memset(bits, false, sizeof(bits));
		else {
			cin >> tar;
			if (order == "add") bits[tar] = true;
			else if (order == "remove") bits[tar] = false;
			else if (order == "check") (bits[tar]) ? cout << "1\n" : cout << "0\n";
			else bits[tar] = !bits[tar];
		}
	}
	return 0;
}
