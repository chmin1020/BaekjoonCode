#include <iostream>
#include <cstring>

int findNP(int che[],int cur,bool up) {
	while (che[cur] == 1) {
		if (up)cur++;
		else cur--;
	}
	return cur;
}

int main() {
	int che[10001];
	int tst,num,a1,a2;

	memset(che, 0, sizeof(che));
	for (int i = 2; i < 5000; i++) {
		if (che[i] == 1) continue;
		for (int j = i * 2; j < 10001; j += i)
			che[j] = 1;
	}
	
	std::cin >> tst;
	for (int i = 0; i < tst; i++) {
		std::cin >> num;
		a1 = a2 = num / 2;
		a1 = findNP(che, a1, false);
		a2 = findNP(che, a2, true);
		
		while (1) {
			if (a1 + a2 > num) a1 = findNP(che, a1 - 1, false);
			else if (a1 + a2 < num) a2 = findNP(che, a2 + 1, true);
			else break;
		}
		std::cout << a1 << ' ' << a2 << '\n';
	}
	return 0;
}
