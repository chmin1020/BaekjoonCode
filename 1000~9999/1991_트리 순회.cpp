#include <iostream>
#include <map>
using namespace std;
map<char, pair<char, char>> tree;

void preOrder(char node) {
	cout << node;
	if (tree[node].first != '.') preOrder(tree[node].first);
	if (tree[node].second != '.') preOrder(tree[node].second);
}
void inOrder(char node) {
	if (tree[node].first != '.') inOrder(tree[node].first);
	cout << node;
	if (tree[node].second != '.') inOrder(tree[node].second);
}
void postOrder(char node) {
	if (tree[node].first != '.') postOrder(tree[node].first);
	if (tree[node].second != '.') postOrder(tree[node].second);
	cout << node;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int cnt;
	char parent, left, right;
	
	cin >> cnt;
	for (int i = 0; i < cnt; i++) {
		cin >> parent >> left >> right;
		tree.insert(make_pair(parent, make_pair(left, right)));
	}
	preOrder('A'); cout << "\n";
	inOrder('A'); cout << "\n";
	postOrder('A'); cout << "\n";
	return 0;
}
