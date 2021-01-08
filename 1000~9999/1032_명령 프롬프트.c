#include <stdio.h>
#include <string.h>

int main()
{
	int num;
	char fileN[51][51];

	scanf("%d", &num);

	for (int i = 0; i < num; i++)
		scanf("%s", fileN[i]);

	int j = strlen(fileN[0]);
	for (int i = 1; i < num; i++)
	{
		for (int k = 0; k < j; k++)
			if (fileN[0][k] != fileN[i][k])
				fileN[0][k] = '?';
	}
	printf("%s\n", fileN[0]);

	return 0;
}
