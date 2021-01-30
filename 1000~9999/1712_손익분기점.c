#include <stdio.h>

int main()
{
	int fix, flux, price;
	scanf("%d %d %d", &fix, &flux, &price);

	if (flux >= price) //손익분기점 x
		printf("-1\n");
	else //손익분기점 O
		printf("%d\n", fix / (price - flux) + 1);
	
	return 0;
}
