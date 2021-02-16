#include <iostream>
#include <cmath>
#include <cstring>

int main() {
	int che[1001];
	int num, tmp, cnt = 0;
	memset(che, 0, sizeof(che));
	che[1] = 1;

	for (int i = 2; i < 1001; i++) {
		if (che[i] == 1) continue;
		for (int j = 2*i; j < 1001; j += i)
			che[j] = 1;
	}
	std::cin >> num;
	for (int i = 0; i < num; i++) {
		std::cin >> tmp;
		if (che[tmp] == 0) cnt++;
	}
	std::cout << cnt << '\n';
	return 0;
}
