#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
 
    long long answer = 1;
    int arr[20];
    int S, K, rest, i;

    cin >> S >> K;

    rest = S % K;
    for (i = 0; i < K; i++)
        arr[i] = S / K;   

    i = 0;
    while (rest != 0) {
        arr[i]++;
        rest--;
        i = (i + 1) % K;
    }

    for (i = 0; i < K; i++)
        answer *= arr[i];
    cout << answer;

    return 0;
}
