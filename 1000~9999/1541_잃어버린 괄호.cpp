#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main() {
	string folmula;
	vector<int> num;
	vector<char> op;
	vector<int> tp;

	cin >> folmula;

	//숫자와 연산자 분리
	int tmp = 0;
	for (int i = 0; i < (signed int)folmula.size(); i++) {

		if (folmula[i] == '+' || folmula[i] == '-') {
			num.push_back(stoi(folmula.substr(i - tmp, tmp)));
			tmp = 0;
			op.push_back(folmula[i]);
		}
		else if (i == folmula.size() - 1) 
			num.push_back(stoi(folmula.substr(i - tmp, tmp + 1)));
		else tmp++;
	}

	//더하기 먼저
	int idx = 0;
	tp.push_back(num[0]);
	for (int i = 1; i < num.size(); i++) {
		if (op[i - 1] == '+')
			tp[idx] += num[i];
		else {
			idx++;
			tp.push_back(num[i]);
		}
	}

	//빼기 시행 후 결과 출력
	int result = tp[0];
	for (int i = 1; i < tp.size(); i++)
		result -= tp[i];
	cout << result << '\n';

	return 0;
}
