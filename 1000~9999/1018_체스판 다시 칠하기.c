#include <stdio.h>

int main()
{
	char board[50][50];
	int whiteF[50][50], blackF[50][50];
	int n, m, min = 2501, sumW = 0, sumB = 0;

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		scanf("%s", board[i]);
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) // 맨위 왼쪽 흰색, 검은색 시뮬레이션
		{
			if (i % 2 == j % 2 && board[i][j] == 'B')
			{
				whiteF[i][j] = 1;
				blackF[i][j] = 0;
			}
			else if (i % 2 == j % 2 && board[i][j] == 'W')
			{
				whiteF[i][j] = 0;
				blackF[i][j] = 1;
			}
			else if (i % 2 != j % 2 && board[i][j] == 'W')
			{
				whiteF[i][j] = 1;
				blackF[i][j] = 0;
			}
			else if (i % 2 != j % 2 && board[i][j] == 'B')
			{
				whiteF[i][j] = 0;
				blackF[i][j] = 1;
			}
		}

	}

	for (int i = 0; i < n - 7; i++)
	{
		for (int j = 0; j < m - 7; j++)
		{
			for (int k = i; k < i + 8; k++)
			{
				for (int l = j; l < j + 8; l++)
				{
					sumW += whiteF[k][l];
					sumB += blackF[k][l];
				}
			}

			if (sumW < min) //최솟값 찾기
				min = sumW;
			if (sumB < min)
				min = sumB;
			sumW = 0;
			sumB = 0;
		}
	}
	if (min == 2501) min = 0;
	printf("%d\n", min);

	return 0;
}
