#include <stdio.h>
char space[3000][3000];

void makeSquare(int x, int startX, int startY)
{
	if (x == 3) //3이 입력되었을 때(기본값)
	{
		for (int i = startX; i < startX + 3; i++)
		{
			for (int j = startY; j < startY + 3; j++)
			{
				if ((i % 3) == 1 && (j % 3) == 1)
					continue;
				else
					space[i][j] = '*';
			}
		}
	}
	else //이외의 제곱수(재귀)
	{
		for (int i = startX; i < startX + 3; i++)
		{
			for (int j = startY; j < startY + 3; j++)
			{
				if (i % 3 == 1 && j % 3 == 1)
					continue;
				else
					makeSquare(x / 3, startX + (i-startX)*(x / 3), startY + (j-startY)*(x / 3));
			}
		}
	}
}

int main()
{
	int in;  //in은 3의 거듭제곱수!
	scanf("%d", &in);

	for (int i = 0; i < 3000; i++)
		for (int j = 0; j < 3000; j++)
			space[i][j] = ' ';

	makeSquare(in, 0, 0);

	for (int i = 0; i < in; i++)
	{
		for (int j = 0; j < in; j++)
			printf("%c", space[i][j]);
		printf("\n");
	}
	return 0;
}
