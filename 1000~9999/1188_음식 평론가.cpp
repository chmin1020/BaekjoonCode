#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int sNum, cNum, sum = 0;

	cin >> sNum >> cNum;
	
	int cnt = 0;
	while (sum != sNum * cNum) {
		sum += sNum; 
		if(sum%cNum != 0) cnt++;
	}
	cout << cnt << "\n";
	return 0;
}
