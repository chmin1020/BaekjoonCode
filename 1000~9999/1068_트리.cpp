#include <iostream>
#include <cstring>
using namespace std;
bool treeNode[50];
int treeParent[50];
bool treeChild[50][50];
int treeChildCnt[50];

void delNode(int size, int target) {
	for (int i = 0; i < size; i++) {
		if (treeChild[target][i]) delNode(size, i);
	}
	treeChildCnt[treeParent[target]]--;
	treeChild[treeParent[target]][target] = false;
	treeNode[target] = false;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	memset(treeChild, false, sizeof(treeNode));
	memset(treeChild, 0, sizeof(treeParent));
	memset(treeChild, false, sizeof(treeChild));
	memset(treeChild, 0, sizeof(treeChildCnt));
	int n, tmp;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		treeNode[i] = true;
		treeParent[i] = tmp;
		if (tmp != -1) {
			treeChild[tmp][i] = true;
			treeChildCnt[tmp]++;
		}
	}
	cin >> tmp;
	delNode(n,tmp);
	tmp = 0;
	for (int i = 0; i < n; i++)
		if (treeNode[i] && treeChildCnt[i] == 0) 
			tmp++;
	cout << tmp << '\n';
	return 0;
}
