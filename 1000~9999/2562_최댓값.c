#include <stdio.h>

int main()
{
	int in[9];
	int max = 0 , index;

	for (int i = 0; i < 9; i++)
	{
		scanf("%d", &in[i]);
		if (max < in[i])
		{
			max = in[i];
			index = i;
		}
	}
	printf("%d\n%d\n", max, index + 1);
	return 0;
}
