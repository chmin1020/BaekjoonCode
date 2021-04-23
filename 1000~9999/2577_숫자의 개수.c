#include <stdio.h>

int main()
{
	int a, b, c, result;
	int cnt[10] = {0,};

	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);

	result = a*b*c;

	for (;result != 0;)
	{
		cnt[result % 10]++;
		result /= 10;
	}

	for (int i = 0; i < 10; i++)
	{
		printf("%d\n",cnt[i]);
	}

	return 0;
}
