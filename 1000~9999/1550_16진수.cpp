#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
	string hex;
	int result = 0;
	cin >> hex;

	for (int i = hex.length() - 1; i >= 0; i--) {
		if (hex[i] >= '0' && hex[i] <= '9') 
			result += (hex[i] - '0')*(int)pow(16, hex.length() - i - 1);
		else 
			result += (hex[i] - 'A' + 10)*(int)pow(16, hex.length() - i - 1);
	}
	cout << result << endl;

	return 0;
}
