#include <stdio.h>

int main() {
	int num = 665, cnt = 0, mc = 0, tmp, n;
	scanf("%d", &n);

	while (cnt < n) {
		tmp = ++num;
		while (tmp) {
			if (tmp % 10 == 6) mc++;
			else mc = 0;
			if (mc == 3) cnt++;
			tmp /= 10;
		}
		mc = 0;
	}
	printf("%d\n",num);
	return 0;
}
