#include <iostream>

int main() {
	double a, b;
	std::cout.setf(std::ios::fixed);
	std::cout.precision(9);

	std::cin >> a;
	std::cin >> b;
	std::cout << a / b << std::endl;

	return 0;
}
