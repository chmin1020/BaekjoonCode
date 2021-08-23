#include <iostream>
#include <cstring>
#include <string>
using namespace std;

string matA[50], matB[50];
bool check[50][50];

void swap(int x, int y) {
    for (int i = x; i < x + 3; i++)
        for (int j = y; j < y + 3; j++)
            check[i][j] = !check[i][j];
}

int doPerformance(int n, int m) {
    int answer = 0;

    if (n < 3 || m < 3) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!check[i][j]) return -1;
    }
    else {
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (!check[i][j]) {
                    swap(i, j);
                    answer++;
                }
            }
        }

        for (int i = 0; i < n; i++)
            for(int j = m - 2; j < m; j++)
                if (!check[i][j]) return -1;
   
        for (int i = n - 2; i < n; i++)
            for(int j = 0; j < m - 2; j++)
                if (!check[i][j]) return -1;
    }
    return answer;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
        cin >> matA[i];
    for (int i = 0; i < n; i++)
        cin >> matB[i];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matA[i][j] == matB[i][j]) check[i][j] = true;
            else check[i][j] = false;
        }
    }

    cout << doPerformance(n, m);
    return 0;
}
