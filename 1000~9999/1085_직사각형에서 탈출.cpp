#include <iostream>
using namespace std;

int main() {
	int x, y;
	int w, h;
	int  min = 1001;

	cin >> x >> y >> w >> h;

	if (x < min) min = x;
	if (y < min) min = y;
	if (w - x < min) min = w - x;
	if (h - y < min) min = h - y;
	
	cout << min << endl;
	return 0;
}
