#include <iostream>
#include <cstring>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
   
    int num, tmp, maxN = -1001, minN = 1001;
    int arr[2001];
    memset(arr, 0, sizeof(arr));

    cin >> num;
    for (int i = 0; i < num; i++) {
        cin >> tmp;
        if (tmp > maxN) maxN = tmp;
        if (tmp < minN) minN = tmp;
        arr[tmp + 1000]++;
    }

    for (int i = minN; i <= maxN; i++) 
        if (arr[i + 1000] != 0) cout << i << " ";

    return 0;
}
