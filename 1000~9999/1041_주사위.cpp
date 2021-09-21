#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    bool skipFlag = false;
    long long n, answer = 0;
    int minPoss[3];
    long long minVals[3], dice[6];

    cin >> n;
    for (int i = 0; i < 6; i++)
        cin >> dice[i];
    
    if (n == 1) {
        int tmp = -1;
        for (int i = 0; i < 6; i++) {
            answer += dice[i];
            if (tmp < dice[i]) tmp = dice[i];
        }
        answer -= tmp;
    }
    else {
        for (int i = 0; i < 3; i++) {
            minVals[i] = 51;
            for (int j = 0; j < 6; j++) {
                skipFlag = false;
                for (int k = 0; k < i; k++) {
                    if (j == minPoss[k] || j == 5 - minPoss[k]) {
                        skipFlag = true;
                        break;
                    }
                }
                if (skipFlag) continue;
                if (minVals[i] > dice[j]) {
                    minVals[i] = dice[j];
                    minPoss[i] = j;
                }
            }
        }
        answer += ((n - 2) * (5 * n - 6)) * minVals[0]; //면1
        answer += (8 * n - 12) * (minVals[0] + minVals[1]); //면2
        answer += 4 * (minVals[0] + minVals[1] + minVals[2]); //면3
    }

    cout << answer;
    return 0;
}
