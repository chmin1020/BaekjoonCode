#include <iostream>
using namespace std;

int main() {
	int num, score, max;
	int arr[51];
	int rank = 1;

	cin >> num >> score >> max;

	for (int i = 0; i < 51; i++)
		arr[i] = -1;

	for (int i = 0; i < num; i++)
		cin >> arr[i];

	if (num == max && arr[max - 1] >= score)
		rank = -1;
	else {
		for(int i = 0; i < num; i++)
			if (arr[i] > score)
				rank++;
	}

	cout << rank << "\n";
	
	return 0;
}
