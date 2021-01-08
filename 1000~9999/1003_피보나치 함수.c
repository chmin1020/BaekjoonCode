#include <stdio.h>

int main()
{
	int fib[41];
	fib[0] = 1; fib[1] = 1;

	for (int i = 2; i < 41; i++)
		fib[i] = fib[i - 1] + fib[i - 2];

	int nm,num;
	scanf("%d", &nm);
	for (int i = 0; i < nm; i++) 
	{
		scanf("%d", &num);
		if (num == 0)
			printf("1 0\n");
		else if (num == 1)
			printf("0 1\n");
		else
			printf("%d %d\n", fib[num - 2], fib[num - 1]);
	}

	return 0;
}
