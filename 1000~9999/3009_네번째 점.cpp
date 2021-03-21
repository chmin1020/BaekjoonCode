#include <iostream>

int main() {
	int x1, x2, x3, y1, y2, y3;

	std::cin >> x1 >> y1;
	std::cin >> x2 >> y2;
	std::cin >> x3 >> y3;

	if (x1 != x2 && x1 != x3) std::cout << x1;
	else if (x2 != x1 && x2 != x3) std::cout << x2;
	else std::cout << x3;
	putc(' ', stdout);
	
	if (y1 != y2 && y1 != y3) std::cout << y1;
	else if (y2 != y1 && y2 != y3) std::cout << y2;
	else std::cout << y3;
	putc('\n', stdout);
	return 0;
}
