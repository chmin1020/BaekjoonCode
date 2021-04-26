#include <iostream>
#include <string>
using namespace std;

int main() {
	string str;
	int sum = 0;
	int arr[26] = { 3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10 };
	cin >> str;

	for (int i = 0; i < str.length(); i++)
		sum += arr[str[i] - 65];
	cout << sum << '\n';
	
	return 0;
}
