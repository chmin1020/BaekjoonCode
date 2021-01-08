#include <iostream>
#include <cmath>
using namespace std;

bool che[1000001]; //에라토스뭐시기 체

int main() {
	long long start, end;
	int cnt = 0;
    
	fill_n(che, 1000001, true);
	cin >> start >> end;

	for (long long i = 2; i <= (long long)sqrt(end); i++) {
		for(long long j = (start - 1) / (i*i); j*(i*i) <= end; j++) {
			if (j*(i*i) - start < 0) continue;
			if (che[j*(i*i) - start] == false) continue;
			che[j*(i*i) - start] = false;
			cnt++;
		}
	}

	cout << (end - start + 1) - cnt << endl;
	return 0;
}
