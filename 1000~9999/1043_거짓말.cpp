#include <iostream>
#include <vector>
using namespace std;
vector<int> party[50];
bool witness[51];
int parent[51];

int find(int n) {
	if (parent[n] == n) return n;
	return n = find(parent[n]);
}

void Union(int a, int b) {
	a = find(a);
	b = find(b);
	if(witness[a]) parent[b] = a;
	else parent[a] = b;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, m, know, tp1, tp2, tp3, cnt = 0;
	bool flag = true;

	cin >> n >> m >> know;
	for (int i = 0; i < know; i++) {
		cin >> tp1;
		witness[tp1] = true;
	}

	for (int i = 1; i <= n; i++)
		parent[i] = i;

	for (int i = 0; i < m; i++) {
		cin >> tp1 >> tp2;
		party[i].push_back(tp2);
		for (int j = 1; j < tp1; j++) {
			cin >> tp3;
			Union(tp2, tp3);
			party[i].push_back(tp3);
		}
	}

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < party[i].size(); j++) {
			if (witness[find(party[i][j])]) {
				flag = false; break;
			}
		}
		if (flag) cnt++;
		flag = true;
	}
	cout << cnt << "\n";
	return 0;
}
