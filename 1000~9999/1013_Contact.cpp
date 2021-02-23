#include <iostream>
#include <string>
#include <regex>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	regex pattern("(100+1+|01)+");
	int cases;
	string test;

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> test;
		if (regex_match(test, pattern)) cout << "YES\n";
		else cout << "NO\n";
	}
	return 0;
}
