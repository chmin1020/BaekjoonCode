#include <iostream>
#include <cstring>
using namespace std;

int n, s, ans = 0;
int sequence[20];
bool isUsed[20];

void findSub(int sum, int idx) {
    if (sum == s)
        ans++;

    isUsed[idx] = true;
    for (int i = idx + 1; i < n; i++)
        if (!isUsed[i]) findSub(sum + sequence[i], i);
    isUsed[idx] = false;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    memset(isUsed, false, sizeof(isUsed));

    cin >> n >> s;
    for (int i = 0; i < n; i++)
        cin >> sequence[i];
    
    for (int i = 0; i < n; i++)
        findSub(sequence[i], i);
    cout << ans;
    return 0;
}
