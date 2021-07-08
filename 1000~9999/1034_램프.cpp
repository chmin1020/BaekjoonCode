#include <iostream>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n, m, k;
    int answer = 0;
    string table[50];

    cin >> n >> m;
    for (int i = 0; i < n; i++)
        cin >> table[i];
    cin >> k;

    int cnt, tmp;
    for (int i = 0; i < n; i++) {
        cnt = 0;
        for (int j = 0; j < m; j++)
            if (table[i][j] == '0')
                cnt++;
       
        if (cnt % 2 == k % 2 && cnt <= k) {
            tmp = 0;
            for (int j = 0; j < n; j++) 
                if (table[i] == table[j]) tmp++;
            if (tmp > answer) answer = tmp;
        }
    }
    cout << answer;
    return 0;
}
