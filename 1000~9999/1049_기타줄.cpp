#include <iostream>
using namespace std;

class Brand {
private:
	int setPrice;
	int onePrice;
public:
	Brand() { }
	Brand(int a, int b) {
		setPrice = a;
		onePrice = b;
	}
	void applyPrice(int a, int b) {
		setPrice = a;
		onePrice = b;
	}
	int showSet() {
		return setPrice;
	}
	int showOne() {
		return onePrice;
	}

};

int main() {
	int n, m; //n= 필요한 개수 , m =브랜드 수
	int tmp1, tmp2 , min = 2100000000, setCnt = 0, sixMin = 2100000000;
	cin >> n >> m;

	Brand *list = new Brand[m];

	for (int i = 0; i < m; i++) { //브랜드 목록 정리
		cin >> tmp1 >> tmp2;
		list[i] = Brand(tmp1, tmp2);
		//6개를 사는 최소가격 구해 놓기
		if (tmp1 < sixMin) sixMin = tmp1;
		if (tmp2 * 6 < sixMin) sixMin = tmp2 * 6;
	}

	if (n > 6) { //n이 6보다 클 때	
		tmp1 = n;
		while (tmp1 > 6) {
			setCnt++;
			tmp1 -= 6;
		}
	}
	//n이 6보다 작거나 같을 때
	for (int i = 0; i < m; i++) {
		if (list[i].showSet() < min) min = list[i].showSet();
		if (list[i].showOne()*(n - setCnt * 6) < min) min = list[i].showOne()*(n - setCnt * 6);
	}
	cout << min + setCnt*sixMin << endl;

	delete[]list;
	return 0;
}
