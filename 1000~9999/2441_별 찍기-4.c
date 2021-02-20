#include <stdio.h>

int main() {
	int input, i, j, k;
	scanf("%d", &input);
	for (i = 0; i < input; i++) {
		for (j = 0; j < i; j++)
			putchar(' ');
		for (k = input - i; k > 0; k--)
			putchar('*');
		putchar('\n');
	}
	return 0;
}
