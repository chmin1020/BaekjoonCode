 #include <iostream>
#include <cstring>
using namespace std;

bool che[100001];

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
 
    int a, b, answer = 0;
    int cp, pr, prCnt;

    memset(che, true, sizeof(che));
    che[0] = che[1] = false;

    for (int i = 2; i < 100001; i++) {
        if (che[i])
            for (int j = i * 2; j < 100001; j += i)
                che[j] = false;
    }

    cin >> a >> b;

    for (int i = a; i <= b; i++) {
        cp = i;
        pr = 2;
        prCnt = 0;

        while (cp > 1) {
            while (!che[pr]) pr++;
            while (cp % pr == 0) {
                prCnt++;
                cp /= pr;
            }
            pr++;
        }
        if (che[prCnt]) answer++;
    }

    cout << answer;
    return 0;
}
