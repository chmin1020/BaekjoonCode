#include <stdio.h>
#include <stdlib.h>

int main()
{
	int in, tmp, cnt = 1;
	int *store;
	scanf("%d", &in);
	tmp = in;
	while (tmp / 10 != 0)
	{
		tmp /= 10;
		cnt++;
	}
	store = malloc(sizeof(int)*cnt);
	
	for (int i = 0; i < cnt; i++)
	{
		store[i] = in % 10;
		in /= 10;
	}

	for (int i = 0; i < cnt; i++)
	{
		for (int j = 0; j < cnt - i - 1; j++)
		{
			if (store[j] < store[j + 1])
			{
				tmp = store[j];
				store[j] = store[j + 1];
				store[j + 1] = tmp;
			}
		}
	}

	for (int i = 0; i < cnt; i++)
		printf("%d", store[i]);
	printf("\n");
	free(store);
	return 0;
}
