#include <iostream>
#include <vector>
using namespace std;
vector<pair<int, int>> edge[10001];
bool visited[10001];
int radius = -1, maxNode;

void dfs(int start, int sum) {
	visited[start] = true;
	for (int i = 0; i < (signed int)edge[start].size(); i++) 
		if (!visited[edge[start][i].first]) dfs(edge[start][i].first, sum+edge[start][i].second);
	if (sum > radius) {
		radius = sum;
		maxNode = start;
	}
	visited[start] = false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int node, n1, n2, w;

	cin >> node;
	for (int i = 0; i < node - 1; i++) {
		cin >> n1 >> n2 >> w;
		edge[n1].push_back(make_pair(n2, w));
		edge[n2].push_back(make_pair(n1, w));
	}
	dfs(1, 0); dfs(maxNode, 0);
	cout << radius << "\n";
	return 0;
}
