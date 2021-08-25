#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int dp[1001];
    pair<int,int> cities[20];
    int c, n;
    
    cin >> c >> n;
    for (int i = 0; i < n; i++)
        cin >> cities[i].first >> cities[i].second;
    fill_n(dp, 1001, 200000);
    dp[0] = 0;

    for (int i = 0; i <= c; i++) {
        for (int j = 0; j < n; j++) {
            if (i - cities[j].second >= 0)
                dp[i] = min(dp[i], dp[i - cities[j].second] + cities[j].first);
            else
                dp[i] = min(dp[i], cities[j].first);
        }
    }

    cout << dp[c];
    return 0;
}
