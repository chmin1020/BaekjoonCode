#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
 
    int N, jm, hs;
    int answer = 0;

    cin >> N >> jm >> hs;

    while (jm != hs) {
        jm = (jm + 1) / 2;
        hs = (hs + 1) / 2;
        answer++;
    }

    cout << answer;

    return 0;
}
