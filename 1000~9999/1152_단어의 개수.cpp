#include <iostream>
#include <string>
using namespace std;

int main()
{
	string line;
	int cnt = 1,enterCnt = 0;

	getline(cin,line);

	if (line.length() == 0) //아무것도 입력 안됨
		cout << "0" << endl;
	else 
	{
		for (int i = 0; i < (signed)line.length(); i++)
			if (line[i] == ' ') 
			{
				enterCnt++;
				if (i != 0 && i != line.length() - 1)
					cnt++;
			}
		if (enterCnt == line.length()) //문장이 모두 공백
			cout << "0" << endl;
		else //그 외
			cout << cnt << endl;
	}
		 
	return 0;
}
