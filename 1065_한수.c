#include <stdio.h>

int getH(int lim) {
	if (lim < 100)
		return lim;

	int cnt = 99;
	for(int i = 100; i <= lim; i++)
		if ((i / 10) % 10 - i % 10 == i / 100 - (i / 10) % 10)
			cnt++;
	return cnt;
}

int main() {
	int lim;

	scanf("%d", &lim);
	printf("%d\n", getH(lim));
	return 0;
}
