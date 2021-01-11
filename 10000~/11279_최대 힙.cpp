#include <iostream>
#include <algorithm>
using namespace std;

class Heap {
public:
	int heap[100001], cur = 0;

	void insert(int n) {
		heap[++cur] = n;
		int pointer = cur;
		while (pointer > 1) {
			if (heap[pointer / 2] < heap[pointer]) {
				swap(heap[pointer / 2], heap[pointer]);
				pointer /= 2;
			}
			else break;
		}
	}
	int remove() {
		if (cur == 0) return 0;

		int maxN = heap[1];
		int pointer = 1;
		heap[1] = heap[cur--];
		while (pointer < cur) {
			if (pointer * 2 + 1 <= cur) {
				if (heap[pointer * 2] > heap[pointer * 2 + 1]) {
					if (heap[pointer * 2] > heap[pointer]) {
						swap(heap[pointer], heap[pointer * 2]);
						pointer *= 2;
					}
					else break;
				}
				else {
					if (heap[pointer * 2 + 1] > heap[pointer]) {
						swap(heap[pointer], heap[pointer * 2 + 1]);
						pointer = pointer * 2 + 1;
					}
					else break;
				}
			}
			else if (pointer * 2 <= cur) {
				if (heap[pointer * 2] > heap[pointer])
					swap(heap[pointer], heap[pointer * 2]);
				break;
			}
			else break;
		}
		return maxN;
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n, tmp;
	Heap h;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (tmp == 0) cout << h.remove() << '\n';
		else h.insert(tmp);
	}
	return 0;
}
