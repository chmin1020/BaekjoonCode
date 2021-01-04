#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	int num; //데이터 입력 수
	double x1, y1, r1; //조규현 정보
	double x2, y2, r2; //백승환 정보
	double distance; //둘 사이 거리
	int *store; //결과 저장

	scanf("%d", &num);
	store = malloc(sizeof(int)*num);

	for (int i = 0; i < num; i++) //결과 계산 및 저장
	{
		scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &r1, &x2, &y2, &r2);

		distance = sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));

		if (abs(r2 - r1) < distance && r1 + r2 > distance)
			store[i] = 2;
		else if ((abs(r2 - r1) == distance && r1 != r2) || r1 + r2 == distance)
			store[i] = 1;
		else if (abs(r2 - r1) > distance || r1 + r2 < distance)
			store[i] = 0;
		else if (r1 == r2 && distance == 0)
			store[i] = -1;
		else
			return;
	}

	for (int i = 0; i < num; i++) //결과 출력
		printf("%d\n", store[i]);

	free(store);
	return 0;
}
