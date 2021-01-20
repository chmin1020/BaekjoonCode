#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	deque<int> res;
	string funcs, list;
	int cases, num, start, end;
	bool flag, error;

	cin >> cases;
	for (int i = 0; i < cases; i++) {
		flag = true; error = false;

		cin >> funcs >> num >> list;
		for (int j = 1; res.size() != num;) { //덱에 input
			start = end = j; 
			while (list[end] >= '0' && list[end] <= '9') end++;
			res.push_back(atoi(list.substr(start, end - start).c_str()));
			j = end + 1;
			if (j >= list.size()) break;
		}

		for (int j = 0; j < funcs.length(); j++) { //func 수행
			if (funcs[j] == 'R') flag = !flag;
			else if(funcs[j] == 'D'){
				if (res.empty()) {
					cout << "error\n";
					error = true; break;
				}
				(flag) ? res.pop_front() : res.pop_back();
			}
		}
		if (error) continue;

		cout << "["; //출력
		if (!res.empty()) {
			if (flag) {
				cout << res[0]; res.pop_front();
				while (!res.empty()) {
					cout << "," << res.front();
					res.pop_front();
				}
			}
			else {
				cout << res[res.size() - 1]; res.pop_back();
				while (!res.empty()) {
					cout << "," << res.back();
					res.pop_back();
				}
			}
		}
		cout << "]\n";
	}
	return 0;
}
