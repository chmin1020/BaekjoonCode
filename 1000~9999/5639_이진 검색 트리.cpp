#include <iostream>
using namespace std;
void postOrder(int tree[], int start, int end);

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int tree[10000];
	int t, i = 0;

	while (cin >> t) tree[i++] = t;
	postOrder(tree, 0, i - 1);
	return 0;
}

void postOrder(int tree[], int start, int end) {
	if (start >= end) {
		if(start==end) cout << tree[start] << "\n";
		return;
	}

	int leftEnd = start;
	while (leftEnd < end) {
		if (tree[leftEnd + 1] > tree[start]) break;
		leftEnd++;
	}
	postOrder(tree, start + 1, leftEnd);
	postOrder(tree, leftEnd + 1, end);
	cout << tree[start] << "\n";
}
