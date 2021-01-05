#include <stdio.h>
#include <stdlib.h>

int main()
{
	int num, tmp;
	int *A, *B;
	int result = 0;

	scanf("%d", &num);
	A = malloc(sizeof(int)*num);
	B = malloc(sizeof(int)*num);

	for (int i = 0; i < num; i++)
		scanf("%d", &A[i]);
	for (int i = 0; i < num; i++)
		scanf("%d", &B[i]);

	for (int i = 0; i < num - 1; i++)  //A 배열 정렬
	{
		for (int j = 0; j < num - 1 - i; j++)
		{
			if (A[j] < A[j + 1])
			{
				tmp = A[j];
				A[j] = A[j + 1];
				A[j + 1] = tmp;
			}
		}
	}
	for (int i = 0; i < num - 1; i++) //B 배열 정렬
	{
		for (int j = 0; j < num - 1 - i; j++)
		{
			if (B[j] > B[j + 1])
			{
				tmp = B[j];
				B[j] = B[j + 1];
				B[j + 1] = tmp;
			}
		}
	}
	for (int i = 0; i < num; i++)
		result += (A[i] * B[i]);
	printf("%d\n", result);

	free(A); free(B);
	return 0;
}
