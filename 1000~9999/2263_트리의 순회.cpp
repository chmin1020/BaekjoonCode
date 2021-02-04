#include <iostream>
using namespace std;
int post[100000], in[100000];
void preOrder(int inStart, int postStart, int range);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int num;

	cin >> num;
	for (int i = 0; i < num; i++) cin >> in[i];
	for (int i = 0; i < num; i++) cin >> post[i];
	preOrder(0, 0, num);
	cout << "\n";
	return 0;
}

void preOrder(int inStart, int postStart, int range) {
	if (range <= 0) return;
	cout << post[postStart + range - 1] << " ";

	int cnt = 0;
	while (cnt < range) {
		if (in[inStart + cnt] == post[postStart + range - 1]) break;
		cnt++;
	}
	preOrder(inStart, postStart, cnt);
	preOrder(inStart + cnt + 1, postStart + cnt, range - cnt - 1);
}
