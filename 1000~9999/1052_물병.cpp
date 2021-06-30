#include <iostream>
using namespace std;

int oneCnt(int num) {
    int cnt = 0;
    for (num; num > 0; num /= 2)
        if (num % 2 == 1) cnt++;
    return cnt;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int cur, need, answer = 0;

    cin >> cur >> need;

    while (1) {
        if(need >= oneCnt(cur+answer)) break;
        answer++;
    }

    cout << answer << "\n";
    return 0;
}
