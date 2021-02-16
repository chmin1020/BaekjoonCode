#include <iostream>
#define MAX(a,b) (a>b)?a:b	
using namespace std;

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL);
	int n;
	int in[500][500];
	cin >> n;

	for (int i = 0; i < n; i++) //input
		for (int j = 0; j <= i; j++)
			cin >> in[i][j];

	for (int i = n - 1; i >= 0; i--) { //find
		for (int j = 0; j < i; j++) {
			in[i - 1][j] = MAX(in[i - 1][j] + in[i][j], in[i - 1][j] + in[i][j + 1]);
		}
	}

	cout <<  in[0][0] << '\n'; //output
	return 0;
}
