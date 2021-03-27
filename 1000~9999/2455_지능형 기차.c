#include <stdio.h>

int main() {
	int input, people = 0, ans = 0;

	for (int i = 0; i < 4; i++) {
		scanf("%d", &input);
		people -= input;
		scanf("%d", &input);
		people += input;
		if (ans < people) ans = people;
	}
	printf("%d\n", ans);
	return 0;
}
