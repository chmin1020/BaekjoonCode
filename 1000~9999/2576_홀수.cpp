#include <iostream>
using namespace std;

int main(){
	int number, min = 100 , sum = 0;
	
	for (int i = 0; i < 7; i++) {
		cin >> number;
		if (number % 2 == 1) {
			if (number < min)
				min = number;
			sum += number;
		}
	}
	if (sum == 0) cout << "-1" << endl;
	else cout << sum << "\n" << min << endl;


	return 0;
}
