#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
 
    int num, tp, cnt;
    int line[10];
    int answer[10] = { 0,0,0,0,0,0,0,0,0,0 };

    cin >> num;
    for (int i = 0; i < num; i++)
        cin >> line[i];

    for (int i = 0; i < num; i++) {
        tp = cnt = 0;
        while (cnt < line[i]) {
            if (answer[tp] == 0 || answer[tp] > i) cnt++;
            tp++;
        }
        while (answer[tp] != 0) tp++;
        answer[tp] = i + 1;
    }

    for (int i = 0; i < num; i++)
        cout << answer[i] << " ";

    return 0;
}
