#include <iostream>

int main() {
	long long n, m;
	std::cin >> n >> m;
	n > m ? std::cout << (n - m) << '\n' : std::cout << (m - n) << '\n';
	return 0;
}
