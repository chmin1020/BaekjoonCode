#include <iostream>
#include <cstring>
using namespace std;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	char num[6];
	bool flag = true;
	cin >> num;
	while (strcmp(num,"0")) {
		for (int i = 0, j = strlen(num) - 1; i < j; i++, j--)
			if (num[i] != num[j]) flag = false;
		(flag) ? cout << "yes\n" : cout << "no\n";
		flag = true;
		cin >> num;
	}
	return 0;
}
