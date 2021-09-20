#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

int cnt = 0, target;
vector<int> answer;
bool isUsed[10];

void findTarget(int targetDigit, int curDigit, int num) {
    if (targetDigit == curDigit) {
        cnt++;
        if (cnt == target) answer.push_back(num);
        return;
    }
    
    isUsed[num] = true;
    for (int i = 0; i < num; i++){
        if (!isUsed[i])
            findTarget(targetDigit, curDigit + 1, i);
        if (cnt == target) {
            answer.push_back(num);
            break;
        }
    }
    isUsed[num] = false;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    cin >> target;
    memset(isUsed, false, sizeof(isUsed));
    
    if (target >= 1024) cout << -1;
    else {
        for (int i = 1; ; i++) {
            for (int j = 0; j < 10; j++) {
                findTarget(i, 1, j);
                if (cnt == target) break;
            }
            if (cnt == target) break;
        }
        for (int i = answer.size() - 1; i >= 0; i--)
            cout << answer[i];
    }

    return 0;
}
