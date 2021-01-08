#include <iostream>
#include <cmath>
using namespace std;

class planet {
private:
	int centerX;
	int centerY;
	int radius;
public:
	planet() {}
	planet(int a, int b, int c) {
		centerX = a;
		centerY = b;
		radius = c;
	}
	int showCenterX() {
		return centerX;
	}
	int showCenterY() {
		return centerY;
	}
	int showRadius() {
		return radius;
	}
	double getDistance(int x, int y) {
		return sqrt((double)((centerX -x)*(centerX - x) + (centerY - y)*(centerY - y)));
	}
};

int main() {
	int test, pN;
	int pX, pY;
	int rX, rY;
	int pInclude, rInclude;
	int tmp1, tmp2, tmp3;
	planet *space = NULL;
	cin >> test;

	for (int i = 0; i < test; i++) {
		pInclude = 0, rInclude = 0;
		cin >> pX >> pY >> rX >> rY;

		cin >> pN;
		space = new planet[pN];
		for (int j = 0; j < pN; j++) {
			cin >> tmp1 >> tmp2 >> tmp3;
			space[j] = planet(tmp1, tmp2, tmp3);
		}
		for (int j = 0; j < pN; j++) {
			if (space[j].getDistance(pX, pY) < space[j].showRadius() && space[j].getDistance(rX, rY) > space[j].showRadius())
				pInclude++;
			else if (space[j].getDistance(pX, pY) > space[j].showRadius() && space[j].getDistance(rX, rY) < space[j].showRadius())
				rInclude++;
		}
		cout << pInclude + rInclude << endl; //p와 r이 중복되지 않게 포함된 원 개수 만큼
	}

	return 0;
}
