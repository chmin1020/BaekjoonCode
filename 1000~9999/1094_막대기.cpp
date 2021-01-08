#include <iostream>
#include <random>
using namespace std;

int main() {
	int x, cnt = 0;
	int stick = 64;
	int result = 0;

	cin >> x;


	while (true) {
		if (x - result >= stick) {
			result += stick;
			cnt++;
		}
		else
			stick /= 2;

		if (result == x)
			break;
	}
	cout<<cnt<<"\n";

	return 0;
}
