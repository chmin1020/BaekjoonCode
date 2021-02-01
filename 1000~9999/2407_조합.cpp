#include <iostream>
#include <cstring>
#include <string>
using namespace std;
string result[101][51];

string strAdd(string a, string b) {
	string res="";
	bool carry = false;
	int aStart = a.length() - 1, bStart = b.length() - 1, tmp;

	if (aStart > bStart) {
		while (bStart != aStart){
			b.insert(b.begin(), '0');
			bStart++;
		}
	}
	else {
		while (bStart != aStart) {
			a.insert(a.begin(), '0');
			aStart++;
		}
	}

	while (aStart >= 0) {
		tmp = (a[aStart--] - '0') + (b[bStart--] - '0');
		if(carry) tmp++;
		if (tmp >= 10) {
			tmp -= 10; 
			carry = true;
		}
		else carry = false;
		res.insert(res.begin(), tmp + '0');
	}
	if (carry) res.insert(res.begin(), '1');
	return res;
}

string combination(int n, int r) {
	if (r > n / 2) r = n - r;
	if (n == r || r == 0) result[n][r] = "1";
	else if (result[n][r].empty())
		result[n][r] = strAdd(combination(n - 1, r), combination(n - 1, r - 1));
	return result[n][r];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	
	cin >> n >> m;
	cout << combination(n, m) << "\n";
	return 0;
}
