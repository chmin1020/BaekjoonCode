#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    string words[50];
    int n, ans;

    cin >> n;
    ans = n;
    for (int i = 0; i < n; i++)
        cin >> words[i];

    sort(words, words + n);
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (words[j].substr(0, words[i].length()) == words[i]) {
                ans--;
                break;
            }
        }
    }
    cout << ans;
  
    return 0;
}
