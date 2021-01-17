#include <stdio.h>

int main()
{
	int num, tmp, max = -1;
	int forCal[10] = { 0,0,0,0,0,0,0,0,0,0 };
	
	scanf("%d", &num);
	if (num == 0)
		printf("1\n");
	else
	{
		tmp = num;

		while (tmp != 0)
		{
			forCal[tmp % 10]++;
			tmp /= 10;
		}
		forCal[6] += forCal[9];
		if (forCal[6] % 2 == 1)
			forCal[6] = (forCal[6] + 1) / 2;
		else
			forCal[6] /= 2;

		for (int i = 0; i < 9; i++)
			if (max < forCal[i]) max = forCal[i];
		printf("%d\n", max);
	}
	return 0;
}
