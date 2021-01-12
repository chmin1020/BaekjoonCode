#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string note;

	getline(cin, note);
	if (note.find("1 2 3 4 5 6 7 8") != string::npos) cout << "ascending\n";
	else if (note.find("8 7 6 5 4 3 2 1") != string::npos) cout << "descending\n";
	else cout << "mixed\n";
	return 0;
}
