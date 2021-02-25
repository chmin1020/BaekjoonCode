#include <iostream>
#include <vector>
#include <queue>
using namespace std;
bool map[101][101], check[101][101];
vector<pair<int, char>> direct;

int result(int mLen) {
	queue<pair<int, int>> snake;
	snake.push(make_pair(1, 1));
	check[1][1] = true;
	int sec = 0, di = 0, tr = 0;
	pair<int, int> nextPlace;

	while (1) {
		sec++;
		//머리 위치를 이동
		if (di == 0) {
			if (snake.back().second == mLen) return sec;
			nextPlace.first = snake.back().first; nextPlace.second = snake.back().second + 1;
		}
		else if (di == 1) {
			if (snake.back().first == mLen) return sec;
			nextPlace.first = snake.back().first + 1; nextPlace.second = snake.back().second;
		}
		else if (di == 2) {
			if (snake.back().second == 1) return sec;
			nextPlace.first = snake.back().first; nextPlace.second = snake.back().second - 1;
		}
		else {
			if (snake.back().first == 1) return sec;
			nextPlace.first = snake.back().first - 1; nextPlace.second = snake.back().second;
		}

		//본인 몸에 닿을 시
		if (check[nextPlace.first][nextPlace.second]) 
			return sec;

		check[nextPlace.first][nextPlace.second] = true;
		snake.push(nextPlace);

		//사과를 먹는지 안먹는지
		if (!map[nextPlace.first][nextPlace.second]) {
			check[snake.front().first][snake.front().second] = false;
			snake.pop();
		}
		else 
			map[nextPlace.first][nextPlace.second] = false;


		if (tr < direct.size() && direct[tr].first == sec) {
			//방향 전환
			if (direct[tr].second == 'L') {
				di--;
				if (di < 0) di = 3;
				else di %= 4;
			}
			else {
				di++;
				di %= 4;
			}
			tr++;
		}
	}
	return sec;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int mLen, num, posX, posY;

	cin >> mLen;
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> posX >> posY;
		map[posX][posY] = true;
	}
	cin >> num;
	direct.resize(num);
	for (int i = 0; i < num; i++)
		cin >> direct[i].first >> direct[i].second;

	cout << result(mLen) << "\n";
	return 0;
}
