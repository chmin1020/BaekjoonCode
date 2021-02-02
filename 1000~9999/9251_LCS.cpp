#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string str1, str2;
	int comp[1001][1001];

	memset(comp, 0, sizeof(comp));
	cin >> str1 >> str2;
	str1.insert(str1.begin(), ' ');
	str2.insert(str2.begin(), ' ');

	for (int i = 1; i < str1.length(); i++) {
		for (int j = 1; j < str2.length(); j++) {
			if (str1[i] == str2[j]) comp[i][j] = comp[i - 1][j - 1] + 1;
			else comp[i][j] = max(comp[i - 1][j], comp[i][j - 1]);
		}
	}
	cout << comp[str1.length() - 1][str2.length() - 1] << "\n";
	return 0;
}
