#include <iostream>
#include <cmath>
using namespace std;

class pos {
public:
	int x;
	int y;
};

int main() {
	int cnt, tmp;

	cin >> cnt;

	pos *table = new pos[cnt];
	pos maxP, minP;

	cin >> table[0].x >> table[0].y;
	maxP.x = table[0].x; maxP.y = table[0].y;
	minP.x = table[0].x; minP.y = table[0].y;
	for (int i = 1; i < cnt; i++) {
		cin >> table[i].x >> table[i].y;

		if (maxP.x + maxP.y < table[i].x + table[i].y)
			maxP = table[i];
		if (minP.x + minP.y > table[i].x + table[i].y)
			minP = table[i];
	}
	tmp = abs(maxP.x - minP.x) + abs(maxP.y - minP.y);

	maxP.x = table[0].x; maxP.y = table[0].y;
	minP.x = table[0].x; minP.y = table[0].y;
	for (int i = 1; i < cnt; i++) {
		if (maxP.x - maxP.y < table[i].x - table[i].y)
			maxP = table[i];
		if (minP.x - minP.y > table[i].x - table[i].y)
			minP = table[i];
	}
	if (tmp > abs(maxP.x - minP.x) + abs(maxP.y - minP.y))
		cout << tmp << endl;
	else 
		cout << abs(maxP.x - minP.x) + abs(maxP.y - minP.y) << endl;

	delete[]table;
	return 0;
}
