#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
       
    int originArr[50], sortArr[50], ansArr[50];
    bool isChecked[50];
    int len;

    cin >> len;
    for (int i = 0; i < len; i++) {
        cin >> originArr[i];
        sortArr[i] = originArr[i];
        isChecked[i] = false;
    }

    sort(sortArr, sortArr + len);
    for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
            if (originArr[i] == sortArr[j] && !isChecked[j]) {
                ansArr[i] = j;
                isChecked[j] = true;
                break;
            }
        }
    }

    for (int i = 0; i < len; i++)
        cout << ansArr[i] << " ";
    return 0;
}
