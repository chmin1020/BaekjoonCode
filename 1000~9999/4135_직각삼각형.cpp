#include <iostream>

int main() {
	int a, b, c, max;
	
	std::cin >> a >> b >> c;
	max = a;
	while (a != 0 && b != 0 && c != 0){
		if (max < b) max = b;
		if (max < c) max = c;
		if (a*a + b*b + c*c == 2 * max*max) std::cout << "right\n";
		else std::cout << "wrong\n";
		std::cin >> a >> b >> c;
		max = a;
	}

	return 0;
}
