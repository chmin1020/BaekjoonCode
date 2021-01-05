#include <stdio.h>
#include <stdlib.h>

int main()
{
	int num, tmp;
	int * realY;
	
	scanf("%d", &num);
	realY = malloc(sizeof(int)*num);

	for (int i = 0; i < num; i++)
		scanf("%d", &realY[i]);
	if (num == 1)
		printf("%d\n", realY[0] * realY[0]);
	else
	{
		for (int i = 0; i < num; i++) //sort
		{
			for (int j = 0; j < num - i - 1; j++)
			{
				if (realY[j] > realY[j + 1])
				{
					tmp = realY[j];
					realY[j] = realY[j + 1];
					realY[j + 1] = tmp;
				}
			}
		}
		printf("%d\n", realY[0] * realY[num - 1]);
	}

	free(realY);
	return 0;
}
