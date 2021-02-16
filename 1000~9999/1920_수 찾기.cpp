#include <iostream>
using namespace std;

void quick_sort(int *data, int start, int end) {
	if (start >= end) {return; }
	int pivot = start; int i = pivot + 1; // 왼쪽 출발 지점
	int j = end; // 오른쪽 출발 지점
	int temp; 
	
	while(i <= j){ // 포인터가 엇갈릴때까지 반복
		while(i <= end && data[i] <= data[pivot]){ i++; }
		while(j > start && data[j] >= data[pivot]){ j--; }
		if(i > j){ // 엇갈림
			temp = data[j]; data[j] = data[pivot]; data[pivot] = temp; }
		else{ // i번째와 j번째를 스왑
			temp = data[i]; data[i] = data[j]; data[j] = temp; }
	} // 분할 계산
	quick_sort(data, start, j - 1);
	quick_sort(data, j + 1, end);
}

int main() {
	std::ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, tmp;
	int* arr, *target;
	cin >> n;
	arr = new int[n];

	for (int i = 0; i < n; i++)
		cin >> arr[i];
	quick_sort(arr, 0, n - 1);


	cin >> tmp;
	target = new int[tmp];

	for (int i = 0; i < tmp; i++)
		cin >> target[i];

	int start, end, middle; //이진탐색
	for (int i = 0; i < tmp; i++) {
		start = 0, end = n - 1, middle = (start + end) / 2;
		while (start <= end) {
			if (arr[middle] < target[i]) start = middle + 1;
			else if (arr[middle] > target[i]) end = middle - 1;
			else break;
			middle = (start + end) / 2;
		}
		if (start <= end) cout << "1\n";
		else cout << "0\n";
	}

	delete[]arr;
	delete[]target;
	return 0;
}
