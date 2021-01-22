#include <iostream>
#include <string>
#include <map>
using namespace std;
map<string, int> kinds;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cases, num, cnt;
	string tmp;
	
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		cin >> num; kinds.clear();
		for (int j = 0; j < num; j++) {
			cin >> tmp >> tmp;
			if (kinds.find(tmp) != kinds.end()) kinds[tmp] += 1;
			else kinds.insert(make_pair(tmp, 1));
		}
		cnt = 1; 
		for (map<string, int>::iterator it = kinds.begin(); it != kinds.end(); it++)
			cnt *= (it->second + 1);
		cout << cnt - 1 << '\n';
	}
	return 0;
}
