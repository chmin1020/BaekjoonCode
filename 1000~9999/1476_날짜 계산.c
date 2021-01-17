#include <stdio.h>

int main()
{
	int E, S, M;  //15 28 19
	
	scanf("%d %d %d", &E, &S, &M);
	
	if (E == 15) E= 0;
	if (S == 28) S = 0;
	if (M == 19) M = 0;

	int i = 1;
	while (1)  //search
	{
		if (i % 15 == E && i % 28 == S && i % 19 == M)
			break;
		i++;
	}

	printf("%d\n", i);

	return 0;
}
