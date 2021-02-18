#include <stdio.h>

int main() {
	int input, i, j;
	scanf("%d", &input);
	for (i = 0; i < input; i++) {
		for (j = input - i; j > 0; j--)
			putchar('*');
		putchar('\n');
	}
	return 0;
}
