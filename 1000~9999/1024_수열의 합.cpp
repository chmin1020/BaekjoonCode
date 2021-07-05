#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n, l, answer = -1;

    cin >> n>> l;

    for (int i = l; i <= 100; i++) {
        if (i % 2 == 0 && n % i == i / 2) { //even
            if ((n / i - (i / 2 - 1)) < 0) break;
            for (int j = 0; j < i; j++)
                cout << (n / i - (i / 2 - 1)) + j << " ";
            return 0;
        }
        else if(i % 2 == 1 && n % i == 0) { //odd
            if ((n / i - (i / 2)) < 0) break;
            for (int j = 0; j < i; j++)
                cout << (n / i - i / 2) + j << " ";
            return 0;
        }
    }

    cout << "-1";
    return 0;
}
