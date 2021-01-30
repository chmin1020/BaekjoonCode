#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	stack<int> st;
	string result;
	int n, arr[100000];
	bool no = false;

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
			
	int j = 1;
	for (int i = 0; i < n; i++) {
		while (j <= n) {
			if (st.empty() || st.top() != arr[i]) {
				st.push(j); result.push_back('+');
			}
			else break;
			j++;
		}
		if (st.top() != arr[i] && j > arr[i]) {
			no = true; break;
		}
		st.pop(); result.push_back('-');
	}
	
	if (no) cout << "NO\n";
	else
		for (int i = 0; i < result.length(); i++)
			cout << result[i] << '\n';
	return 0;
}
