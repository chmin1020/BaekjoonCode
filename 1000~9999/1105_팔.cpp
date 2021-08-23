#include <iostream>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    string l, r;
    int cnt = 0;

    cin >> l >> r;

    if (l == r) {
        for (int i = 0; i < l.length(); i++)
            if (l[i] == '8') cnt++;
    }
    else {
        if (l.length() < r.length()) {
            int gap = r.length() - l.length();
            for (int i = l.length() - 1; i >= 0; i--)
                l[i + gap] = l[i];
            for (int i = 0; i < gap; i++)
                l[i] = '0';
        }

        for (int i = 0; i < l.length(); i++) {
            if (l[i] == r[i]) {
                if (l[i] == '8' && r[i] == '8') cnt++;
            }
            else break;
        }
    }
    cout << cnt;
    return 0;
}
