#include <iostream>
#include <string>
#include <set>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	set<string> list, result;
	string name;
	int noSee, noHear;

	cin >> noSee >> noHear;
	for (int i = 0; i < noSee; i++) {
		cin >> name;
		list.insert(name);
	}
	int cnt = 0;
	for (int i = 0; i < noHear; i++) {
		cin >> name;
		if (list.find(name) != list.end())
			result.insert(name);
	}
	cout << result.size() << '\n';
	for (set<string>::iterator it = result.begin(); it != result.end(); it++)
		cout << *it << '\n';
	return 0;
}
