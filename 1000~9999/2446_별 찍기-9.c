#include <stdio.h>

int main()
{
	int in;
	scanf("%d", &in);

	for (int i = 0; i < in; i++)
	{
		for (int j = 0; j < i; j++)
			printf(" ");
		for (int k = 0; k < 2 * (in - i) - 1; k++)
			printf("*");
		printf("\n");
	}
	for (int i = 1; i < in; i++)
	{
		for (int j = 1; j < in - i; j++)
			printf(" ");
		for (int k = 0; k < 2 * i + 1; k++)
			printf("*");
		printf("\n");
	}
	return 0;
}
