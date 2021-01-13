#include <iostream>
using namespace std;
int map[500][500];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	pair<int, int> answer = make_pair(2000000000,-1);
	int n, m, b, maxH = -1, minH = 257;
	int time = 0, usedB = 0;
	cin >> n >> m >> b;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
			if (maxH < map[i][j]) maxH = map[i][j];
			if (minH > map[i][j]) minH = map[i][j];
		}
	}
	for (int i = minH; i <= maxH; i++) {
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < m; k++) {
				if (map[j][k] - i > 0) {
					usedB -= (map[j][k] - i);
					time += (map[j][k] - i) * 2;
				}
				else if(map[j][k] - i < 0){
					usedB += (i - map[j][k]);
					time += (i - map[j][k]);
				}
			}
		}
		if (usedB <= b && ((answer.first > time) || (answer.first == time && answer.second < i))) answer = make_pair(time, i);
		time = 0; usedB = 0;
	}
	cout << answer.first << " " << answer.second << '\n';
	return 0;
}
