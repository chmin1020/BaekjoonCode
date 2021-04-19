#include <stdio.h>
int map[50][50];
int sX, sY;

int chooseNext(int d, int *x, int *y, int rear) {
	if (d == 0) {
		if (*x > 0 && (map[*x - 1][*y] == 0 || (rear&&map[*x - 1][*y] == 2))) {
			(*x)--; return 1;
		}	
	}
	else if (d == 1) {
		if (*y < sY && (map[*x][*y + 1] == 0 || (rear&&map[*x][*y + 1] == 2))) {
			(*y)++; return 1;
		}
	}
	else if (d == 2) {
		if (*x < sX && (map[*x + 1][*y] == 0 || (rear&&map[*x + 1][*y] == 2))) {
			(*x)++; return 1;
		}
	}
	else {
		if (*y > 0 && (map[*x][*y - 1] == 0 || (rear&&map[*x][*y - 1] == 2))) {
			(*y)--; return 1;
		}
	}
	return 0;
}

int main() {
	int x, y, d, cnt = 1;

	scanf("%d %d", &sX, &sY);
	scanf("%d %d %d", &x, &y, &d);

	for (int i = 0; i < sX; i++)
		for (int j = 0; j < sY; j++)
			scanf("%d", &map[i][j]);

	int originD = d;
	map[x][y] = 2;
	while (1) {
		if (d == 0) d = 3;
		else d--;

		if (chooseNext(d, &x, &y, 0)) {
			cnt++;
			map[x][y] = 2;
			originD = d;
		}
		else if (d == originD) {
			if (chooseNext((d + 2) % 4, &x, &y, 1)) {
				if (map[x][y] == 0) {
					cnt++;
					map[x][y] = 2;
				}
			}
			else break;
		}
	}
	printf("%d\n", cnt);
	return 0;
}


