#include <iostream>
using namespace std;
class Time {public: int sT, eT;};

void mergeSort(int left, int right, Time *arr, Time *newArr, bool isEnd) {
	if (left == right) return;
	int mid = (left + right) / 2, i, j, k;

	mergeSort(left, mid, arr, newArr, isEnd);
	mergeSort(mid + 1, right, arr, newArr, isEnd);


	for (i = left, j = mid + 1, k = left; i <= mid && j <= right;) {
		if (isEnd) {
			if (arr[i].eT <= arr[j].eT) newArr[k++] = arr[i++];
			else newArr[k++] = arr[j++];
		}
		else {
			if (arr[i].sT <= arr[j].sT) newArr[k++] = arr[i++];
			else newArr[k++] = arr[j++];
		}
	}
	while (i <= mid) newArr[k++] = arr[i++];
	while (j <= right) newArr[k++] = arr[j++];
	for (i = left; i <= right; i++) arr[i] = newArr[i];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, cur = 0, cnt = 0;
	Time time[100000], tmp[100000];

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> time[i].sT >> time[i].eT;

	mergeSort(0, n - 1, time, tmp, false);
	mergeSort(0, n - 1, time, tmp, true);

	for (int i = 0; i < n; i++) {
		if (cur <= time[i].sT) {
			cur = time[i].eT;
			cnt++;
		}
	}
	cout << cnt << '\n';
	return 0;
}
