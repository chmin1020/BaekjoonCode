#include <iostream>

class info {
public:
	int height, weight, rank = 1;
};
int main() {
	info list[50];
	int n, x, y;
	
	std::cin >> n;
	for (int i = 0; i < n; i++) {
		std::cin >> x >> y;
		list[i].height = x; list[i].weight = y;
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (list[j].height > list[i].height && list[j].weight > list[i].weight)
				list[i].rank++;
		}
	}
	
	std::cout << list[0].rank;
	for (int i = 1; i < n; i++)
		std::cout << " " << list[i].rank;
	putchar('\n');

	return 0;
}
