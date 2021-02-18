#include <stdio.h>

int main() {
	int input , i, j;
	scanf("%d", &input);
	for (i = 1; i <= input; i++) {
		for (j = 0; j < i; j++)
			putchar('*');
		putchar('\n');
	}
	return 0;
}
