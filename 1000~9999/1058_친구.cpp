#include <iostream>
#include <cstring>
#include <string>
using namespace std;

bool graph[50][50];
bool isVisited[50];
int relation[50];
int tmp;

void calTwoFriend(int n, int size, int cnt) {
    isVisited[n] = true;
    relation[n] = cnt;
    if (cnt >= 2) return;

    for (int i = 0; i < size; i++) {
        if (graph[n][i]) {
            if (!isVisited[i]) {
                tmp++;
                calTwoFriend(i, size, cnt + 1);
            }
            else if (relation[i] == 2 && cnt == 0)
                calTwoFriend(i, size, cnt + 1);
        }
    }
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int n, answer = -1;
    string input;

    memset(graph, false, sizeof(graph));
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> input;
        for (int j = 0; j < n; j++) {
            if (input[j] == 'Y') graph[i][j] = true;
        }
    }

    for (int i = 0; i < n; i++) {
        memset(isVisited, false, sizeof(isVisited));
        memset(relation, 0, sizeof(relation));
        tmp = 0;
        calTwoFriend(i, n, 0);
        if (answer < tmp) answer = tmp;
    }
    cout << answer;
    return 0;
}
