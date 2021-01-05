#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Revert(char* st[], char* a)  //문자 -> 숫자 변환
{
	for (int i = 0; i < 10; i++)
		if (!strcmp(st[i], a))
			return i;
	return -1;
}

int main()
{
	char* str[10] = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
	char* inp;
	int resist = 0;
	inp = malloc(sizeof(char) * 10);
	//저항값 입력
	scanf("%s", inp);
	resist += Revert(str, inp) * 10;
	scanf("%s", inp);
	resist += Revert(str, inp);
	//곱 입력 및 값 출력
	scanf("%s", inp);

	if (resist == 0)
	{
		printf("0\n");
	}
	else
	{
		printf("%d", resist);
		for (int i = 0; i < Revert(str, inp); i++)
			printf("0");
		printf("\n");
		free(inp);
	}
	return 0;
}
