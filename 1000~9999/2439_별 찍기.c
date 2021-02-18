#include <stdio.h>

int main() {
	int input, i, j, k;
	scanf("%d", &input);
	for (i = 1; i <= input; i++) {
		for (j = input - i; j > 0; j--)
			putchar(' ');
		for (k = 1; k <= i; k++)
			putchar('*');
		putchar('\n');
	}
	return 0;
}
