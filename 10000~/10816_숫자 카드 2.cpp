#include <iostream>
#include <vector>
using namespace std;

void mergeSort(int first, int last, int arr[], int newArr[]) {
	if (first == last) return;
	int i, j, k, mid = (first + last) / 2;

	mergeSort(first, mid, arr, newArr);
	mergeSort(mid + 1, last, arr, newArr);
	for (i = first, j = mid + 1, k = first; i <= mid && j <= last;) {
		if (arr[i] < arr[j]) newArr[k++] = arr[i++];
		else newArr[k++] = arr[j++];
	}
	while (i <= mid) newArr[k++] = arr[i++];
	while (j <= last) newArr[k++] = arr[j++];
	for (int i = first; i <= last; i++) arr[i] = newArr[i];
}
void doMSort(int arr[], int size) {
	int newArr[500000];
	mergeSort(0, size - 1, arr, newArr);
}
int bound(int target, int size, int arr[], bool isUpper) {
	int left = 0, right = size - 1, mid;
	while (left <= right) {
		mid = (left + right) / 2;
		if (arr[mid] > target) 
			right = mid - 1;
		else if (arr[mid] == target) {
			if (isUpper) {
				if (mid == size - 1 || arr[mid + 1] != target) return mid;
				left = mid + 1;
			}
			else {
				if (mid == 0 || arr[mid - 1] != target) return mid;
				right = mid - 1;
			}
		}
		else
			left = mid + 1;
	}
	return (isUpper) ? -1 : 0;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int size1, size2;
	int list[500000], find[500000];

	cin >> size1;
	for (int i = 0; i < size1; i++)
		cin >> list[i];
	doMSort(list, size1);

	cin >> size2;
	for (int i = 0; i < size2; i++)
		cin >> find[i];
	for (int i = 0; i < size2; i++)
		cout << bound(find[i], size1, list, true) - bound(find[i], size1, list, false) + 1 << ' ';
	cout << '\n';
	return 0;
}
