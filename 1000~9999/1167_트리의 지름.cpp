#include <iostream>
#include <vector>
using namespace std;
vector<pair<int, int> > vertice[100001];
bool visited[100001];
int res = -1, one;

void dfs(int start, int sum) {
	visited[start] = true; 
	for (int j = 0; j < vertice[start].size(); j++)
		if (!visited[vertice[start][j].first])
			dfs(vertice[start][j].first, sum + vertice[start][j].second);

	if (sum > res) {
		res = sum;
		one = start;
	}
	visited[start] = false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int v, x, y, dis;
	
	cin >> v;
	for (int i = 0; i < v; i++) {
		cin >> x;
		while (1) {
			cin >> y;
			if (y == -1) break;
			cin >> dis;
			vertice[x].push_back(make_pair(y, dis));
		}
	}
	dfs(1, 0);
	dfs(one, 0);
	cout << res << "\n";
	return 0;
}
