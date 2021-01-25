#include <iostream>
#include <string>
#include <map>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m;
	string site, pw;
	map <string, string> memo;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> site >> pw;
		memo.insert(make_pair(site, pw));
	}
	for (int i = 0; i < m; i++) {
		cin >> site;
		cout << memo[site] << "\n";
	}
	return 0;
}
