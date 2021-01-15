#include <iostream>
#include <map>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	map<int, string> dic1;
	map<string, int> dic2;
	int listN, targetN;
	string tmp;
	
	cin >> listN >> targetN;
	for (int i = 0; i < listN; i++) {
		cin >> tmp;
		dic1.insert(make_pair(i + 1, tmp));
		dic2.insert(make_pair(tmp, i + 1));
	}
	for (int i = 0; i < targetN; i++) {
		cin >> tmp;
		if (atoi(tmp.c_str()) == 0) cout << dic2[tmp]<< '\n';
		else cout << dic1[atoi(tmp.c_str())] << '\n';
	}
	return 0;
}
