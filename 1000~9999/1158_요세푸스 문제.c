#include <stdio.h>
#include <stdlib.h>

typedef enum{false,true} bool;

int main()
{
	int N, K, erase = 1;
	bool *circle;

	scanf("%d %d", &N, &K);
	circle = malloc(sizeof(int)*N); //메모리 할당
	
	for (int i = 0; i < N; i++) circle[i] = false;

	int index = K%N, scnt = 0; //첫번째를 미리 지우고 시작하므로 index를 그 이후에 할당
	
	printf("<%d", K); //첫번째 지우기 미리 함(지우기는 true)
	circle[K - 1] = true;
	
	for (int i = 0; i < N - 1; i++) //과정
	{
		while (scnt < K)
		{
			if (circle[index] != true)
				scnt++;
			if(scnt != K)
				index = (index + 1) % N;
		}
		scnt = 0;
		circle[index] = true;
		printf(", %d", index + 1);

		index = (index + 1) % N;
	}
	printf(">\n");

	free(circle);
	return 0;
}
