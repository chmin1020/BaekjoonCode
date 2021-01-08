#include <iostream>
#include <string>
#include <deque>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	deque<int> deck;
	string order;
	int n, num;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> order;
		if (order == "push_front") {
			cin >> num;
			deck.push_front(num);
		}
		else if (order == "push_back") {
			cin >> num;
			deck.push_back(num);
		}
		else if (order == "pop_front") {
			if (deck.empty()) cout << "-1\n";
			else {
				cout << deck.front() << '\n';
				deck.pop_front();
			}
		}
		else if (order == "pop_back") {
			if (deck.empty()) cout << "-1\n";
			else {
				cout << deck.back() << '\n';
				deck.pop_back();
			}
		}
		else if (order == "size")
			cout << deck.size() << '\n';
		else if (order == "empty")
			cout << deck.empty() << '\n';
		else if (order == "front")
			(deck.empty()) ? cout << "-1\n" : cout << deck.front() << '\n';
		else
			(deck.empty()) ? cout << "-1\n" : cout << deck.back() << '\n';
	}
	return 0;
}
