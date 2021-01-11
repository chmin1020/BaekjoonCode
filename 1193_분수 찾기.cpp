#include <iostream>
using namespace std;

int main()
{
	int num, fS, fM, i = 0, flag = 1;
	cin >> num;

	while(i!=num)
	{
		for (int j = 0; j < flag; i++, j++)
		{
			if (i == num) break;
			if (flag % 2 == 1) //홀수면 flag/1 로 시작
			{
				fS = flag - j;
				fM = j + 1;
			}
			else //짝수면 반대
			{
				fS = j + 1;
				fM = flag - j;
			}
		}
		flag++;
	}

	cout << fS << "/" << fM << endl;

	return 0;
}
