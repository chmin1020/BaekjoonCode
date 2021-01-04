#include <iostream>
using namespace std;


int main() {
	int T;
	long long west, east;
	
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> west >> east;

		if (west == east) {
			cout << "1" << endl;
		}
		else {
			long long mo = 1, so = 1;

			for (int j = 0; j < west; j++) {
				mo *= (east - j);
				so *= (j + 1);

				if (mo%so == 0) {
					mo /= so;
					so = 1;
				}
			}
			cout << mo / so << endl;
		}
	}
	return 0;
}
