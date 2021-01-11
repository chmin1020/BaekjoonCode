#include <stdio.h>

int main()
{
	char word[1000000];
	int alphabet[26] = { 0, };
	int i = 0;

	scanf("%s", word);

	while (word[i] != '\0')
	{
		if (word[i] >= 97)
			word[i] -= 32;
		alphabet[word[i] - 65]++;
		i++;
	}

	int max = -1;
	int flag = 1;
	for (i = 0; i < 26; i++)
	{		
		if (alphabet[i] > alphabet[max])
		{
			max = i;
			flag = 0;
		}
		else if (alphabet[i] == alphabet[max])
			flag = 1;
	}

	if (flag == 1)
		printf("?\n");
	else
		printf("%c\n", max + 65);


	return 0;
}
