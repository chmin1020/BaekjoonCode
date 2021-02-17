#include <iostream>
#include <cstring>
#include <cmath>
#include <algorithm>

int main() {
	int number[8002];
	int n, tmp, tar, most, min = 4001, max = -4001, mid = -4001, mc = 0;
	double sum = 0;
	memset(number, 0, sizeof(number));

	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::cin >> tmp;;
		sum += tmp;
		if (tmp > max) max = tmp;
		if (tmp < min) min = tmp;

		number[tmp + 4000]++;
	}
	
	tmp = 0; tar = *std::max_element(number, number + sizeof(number) / sizeof(int));
	for (int i = 0; i < 8001; i++){ 
		tmp += number[i];
		if (tmp >= n / 2 + 1 && mid == -4001) mid = i - 4000;
		if (number[i] == tar && mc != 2) {
			most = i - 4000;
			mc++;
		}
	}
	std::cout << (int)round(sum / n) << '\n' << mid << '\n' << most << '\n' << max - min << '\n';
	return 0;
}
