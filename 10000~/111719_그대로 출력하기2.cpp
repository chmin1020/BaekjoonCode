#include <iostream>
#include <string>

int main() {
	std::string input;

	for (;getline(std::cin,input);)
		std::cout << input << std::endl;
	
	return 0;
}
