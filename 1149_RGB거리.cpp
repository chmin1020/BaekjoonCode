#include <iostream>

#define MIN(X,Y)  (X >= Y ? Y : X)
using namespace std;

int main() {
	int arr[3][1000]; //dynamic programming을 위한 배열
	int cost[3]; // 페인트 색에 따른 가격을 저장하는 배열
	int cnt;

	cin >> cnt;

	cin >> cost[0] >> cost[1] >> cost[2];
	arr[0][0] = cost[0];
	arr[1][0] = cost[1];
	arr[2][0] = cost[2];

	for (int i = 1; i < cnt; i++) {
		cin >> cost[0] >> cost[1] >> cost[2];

		arr[0][i] = cost[0] + MIN(arr[1][i - 1], arr[2][i - 1]);
		arr[1][i] = cost[1] + MIN(arr[0][i - 1], arr[2][i - 1]);
		arr[2][i] = cost[2] + MIN(arr[0][i - 1], arr[1][i - 1]);
	}

	cout << MIN(MIN(arr[0][cnt - 1], arr[1][cnt - 1]), arr[2][cnt - 1]);


	return 0;
}
