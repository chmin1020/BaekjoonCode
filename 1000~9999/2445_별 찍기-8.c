#include <stdio.h>

int main()
{
	int in;
	scanf("%d", &in);

	for (int i = 1; i <= in; i++)
	{
		for (int j = 0; j < i; j++)
			printf("*");
		for (int k = 0; k < 2 * (in - i); k++)
			printf(" ");
		for (int j = 0; j < i; j++)
			printf("*");
		printf("\n");
	}
	for (int i = 0; i < in - 1; i++)
	{
		for (int j = 1; j < in - i; j++)
			printf("*");
		for (int k = 0; k < 2 * i + 2; k++)
			printf(" ");
		for (int j = 1; j < in - i; j++)
			printf("*");
		printf("\n");
	}
	return 0;
}
