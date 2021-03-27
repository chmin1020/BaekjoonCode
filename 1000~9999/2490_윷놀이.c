#include <stdio.h>

int main() {
	int wood[4];
	int zero;
	char result;
	for (int i = 0; i < 3; i++) {
		zero = 0;
		scanf("%d %d %d %d", &wood[0], &wood[1], &wood[2], &wood[3]);

		for (int j = 0; j < 4; j++)
			if (wood[j] == 0) zero++;
		switch (zero){
			case 0: result = 'E'; break;
			case 1: result = 'A'; break;
			case 2: result = 'B'; break;
			case 3: result = 'C'; break;
			default: result = 'D';
		}
		printf("%c\n", result);
	}

	return 0;
}
