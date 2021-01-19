#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
bool vertice[1001][1001], visited[1001];

void DFS(int start, int vCtn) {
	visited[start] = true;
	cout << start << " ";
	for (int i = 1; i <= vCtn; i++)
		if (vertice[start][i] && !visited[i])
			DFS(i, vCtn);
}

void BFS(int start, int vCtn) {
	queue<int> bfsQ;
	visited[start] = true; bfsQ.push(start);
	while (!bfsQ.empty()) {
		cout << bfsQ.front() << " ";
		for (int i = 1; i <= vCtn; i++) {
			if (vertice[bfsQ.front()][i] && !visited[i]) {
				visited[i] = true;
				bfsQ.push(i);
			}
		}
		bfsQ.pop();
	}
	cout << '\n';
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int vCtn, eCtn, start, v1, v2;

	cin >> vCtn >> eCtn >> start;
	for (int i = 0; i < eCtn; i++) {
		cin >> v1 >> v2;
		vertice[v1][v2] = vertice[v2][v1] = true;
	}
	DFS(start, vCtn); cout << '\n';
	memset(visited, false, sizeof(visited));
	BFS(start, vCtn);
	return 0;
}
