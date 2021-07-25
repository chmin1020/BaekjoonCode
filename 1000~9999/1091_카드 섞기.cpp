#include <iostream>
using namespace std;

bool check(int *arr, int *P, int size) {
    for (int i = 0; i < size; i++) {
        if (P[arr[i]] != i % 3) return false;
    }
    return true;
}

void shuffle(int *arr, int *tpArr, int *S, int size) {
    for (int i = 0; i < size; i++)
        tpArr[S[i]] = arr[i];
    for (int i = 0; i < size; i++)
        arr[i] = tpArr[i];
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int S[48], P[48];
    int num, i;
    int arr[48], tpArr[48];
    
    cin >> num;
    for (i = 0; i < num; i++)
        cin >> P[i];
    for (i = 0; i < num; i++)
        cin >> S[i];

    for (i = 0; i < num; i++)
        arr[i] = i;

   
    i = 0;
    while (130000 > i) {
        if (check(arr, P, num)) break;

        shuffle(arr, tpArr, S, num);
        i++;
    }
    (i >= 130000) ? cout << -1 : cout << i;
 
    return 0;
}
