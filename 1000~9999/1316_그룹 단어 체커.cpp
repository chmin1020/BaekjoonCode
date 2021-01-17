#include <iostream>
#include <string>
using namespace std;

int main() {
	int num, j, no = 0, cnt = 0;
	bool flag[26], mark = true;
	char tmp;
	string *store;
	
	for (int i = 0; i < 26; i++)
		flag[i] = true;
	
	cin >> num;
	store = new string[num];

	for (int i = 0; i < num; i++) {
		cin >> store[i];
		tmp = store[i][0];

		flag[(int)(tmp - 'a')] = false;
		for (j = 1; j < store[i].length(); j++) {
			if (store[i][j] != tmp) {
				if (flag[(int)(store[i][j] - 'a')] == false) {
					mark = false;
					break;
				}
				flag[(int)(tmp - 'a')] = false;
				tmp = store[i][j];
			}
		}
		if (mark == false) {
			no++;
			mark = true;
		}
		for (int i = 0; i < 26; i++)
			flag[i] = true;
	}
	cout << num - no << endl;
	delete[]store;
}
