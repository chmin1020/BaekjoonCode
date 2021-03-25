#include <cstdio>

void chkSN(bool arr[]) {
	int sum;
	int tmp;
	for (int i = 0; i < 10000; i++) {
		sum = tmp = i + 1;
		while (tmp != 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		if (10000 > sum - 1)
			arr[sum - 1] = false;
	}
}

int main() {
	bool arr[10000];
	
	for (int i = 0; i < 10000; i++) arr[i] = true;
	chkSN(arr);

	for (int i = 0; i < 10000; i++)
		if (arr[i])
			printf("%d\n", i + 1);
	return 0;
}
