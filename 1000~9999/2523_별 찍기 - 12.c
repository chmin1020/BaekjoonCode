#include <stdio.h>

int main()
{
	int in;
	scanf("%d", &in);

	for (int i = 0; i < in; i++)
	{
		for (int j = 0; j <= i; j++)
			printf("*");
		printf("\n");
	}
	for (int i = in-1; i > 0; i--)
	{
		for (int j = 1; j <= i; j++)
			printf("*");
		printf("\n");
	}
	return 0;
}
