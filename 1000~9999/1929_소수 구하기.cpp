#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int a, b;
	
	//두 수 입력받기
	cin >> a >> b;

	bool * arr = new bool[b + 1];
	
	for (int i = 0; i < b + 1; i++)
		arr[i] = true;
	arr[1] = false;

	//체
	for (long i = 2; i < sqrt(b+1); i++) {
		
		if (arr[i] == false) continue;
		for (long j = i*i; j < b + 1; j += i) {
			arr[j] = false;
		}
	}

	for (int i = a; i < b + 1; i++)
		if (arr[i] == true)
			cout << i << "\n";

	delete[]arr;
	return 0;
}
