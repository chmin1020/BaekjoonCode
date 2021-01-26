#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
using namespace std;
typedef pair<int, int> pi;
int sea[50][50];
bool visited[50][50];

class shark {
public:
	pi pos, prey[400];
	int size, stomach, distance, min, pCnt = 0;

	shark() {
		size = 2;
		stomach = 0;
		distance = 0;
	}
	void sizeCheck() {
		if (++stomach == size) {
			size++; stomach = 0;
		}
	}
	void isPrey(pi p, int dis) {
		if (sea[p.first][p.second] < size) {
			if (pCnt == 0) min = dis;
			if (min == dis) prey[pCnt++] = p;
		}
	}
	bool eat() {
		sort(prey, prey + pCnt);
		if (pCnt != 0) {
			sizeCheck();
			sea[pos.first][pos.second] = 0;
			pos = prey[0];
			sea[pos.first][pos.second] = 9;
			distance += min;

			memset(visited, false, sizeof(visited));
			pCnt = 0;		
			return true;
		}
		return false;
	}
};

void bfs(int n, shark &baby) {
	int x, y;
	queue<pair<pi, int>> pos;
	do {
		pos.push(make_pair(baby.pos, 0));
		visited[baby.pos.first][baby.pos.second] = true;
		while (!pos.empty()) {
			if (baby.pCnt != 0 && pos.front().second > baby.min) break;
			x = pos.front().first.first; y = pos.front().first.second;
			
			if (sea[x][y] > 0 && sea[x][y] < baby.size && pos.front().second > 0)
				baby.isPrey(pos.front().first, pos.front().second);

			if (x > 0 && !visited[x - 1][y] && sea[x - 1][y] <= baby.size) { //top
				visited[x - 1][y] = true;
				pos.push(make_pair(make_pair(x - 1, y), pos.front().second + 1));
			}
			if (y > 0 && !visited[x][y - 1] && sea[x][y - 1] <= baby.size) { //left
				visited[x][y - 1] = true;
				pos.push(make_pair(make_pair(x, y - 1), pos.front().second + 1));
			}
			if (y < n - 1 && !visited[x][y + 1] && sea[x][y + 1] <= baby.size) { //right
				visited[x][y + 1] = true;
				pos.push(make_pair(make_pair(x, y + 1), pos.front().second + 1));
			}
			if (x < n - 1 && !visited[x + 1][y] && sea[x + 1][y] <= baby.size) { //bottom
				visited[x + 1][y] = true;
				pos.push(make_pair(make_pair(x + 1, y), pos.front().second + 1));
			}
			pos.pop();
		}		
		while (!pos.empty()) pos.pop();
	} while (baby.eat());
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n;
	shark baby;
	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> sea[i][j];
			if (sea[i][j] == 9) baby.pos = make_pair(i, j);
		}
	}
	bfs(n, baby);
	cout << baby.distance << "\n";
	return 0;
}
