#include <iostream>
using namespace std;

int main() {
	int num, ten, one, cnt = 0;
	int ori;

	cin >> num;
	ori = num;

	do{
		ten = num % 10;
		one = ((num / 10) + (num % 10)) % 10;
		num = ten * 10 + one;
		cnt++;
	} while (ori != num);
	cout << cnt << "\n";
	return 0;
}
