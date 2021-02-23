#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int num, max = -1, tmp;
	vector<int> student;

	cin >> num;
	student.resize(num);
	for (int i = 0; i < num; i++) {
		cin >> student[i];
		if (max < student[i]) max = student[i];
	}
	vector<int> cnt(max + 1, 0);
	for (int i = 0; i < num; i++)
		cnt[student[i]]++;

	for (int i = 0; i < num; i++) {
		if (student[i] == 1) tmp = 0;
		else {
			tmp = cnt[1];
			for (int j = 2; j*j <= student[i]; j++) {
				if (student[i] % j == 0) {
					tmp += cnt[j];
					if (j*j != student[i]) tmp += cnt[student[i] / j];
				}
			}
		}
		if (cnt[student[i]] > 0) tmp += (cnt[student[i]] - 1);
		cout << tmp << "\n";
	}
	return 0;
}
