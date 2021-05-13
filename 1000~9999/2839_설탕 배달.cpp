#include <iostream>
using namespace std;

int main() {
	int order;
	int i,j;
	int min = -1;

	cin >> order;
	
	for (i = order / 5; i >= 0; i--) {
		for (j = 0; (j*3) < (order - i*5); j++);
		if ((5 * i + 3 * j) == order) 
			if ((min == -1) || (min != -1 && min > i + j))
				min = i + j;
	}

	cout << min << endl;
}
