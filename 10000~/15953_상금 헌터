#include <iostream>
using namespace std;

int firstPrice(int rank) {
    if (rank == 1) return 5000000;
    else if (rank >= 2 && rank <= 3) return 3000000;
    else if (rank >= 4 && rank <= 6) return 2000000;
    else if (rank >= 7 && rank <= 10) return 500000;
    else if (rank >= 11 && rank <= 15) return 300000;
    else if (rank >= 16 && rank <= 21) return 100000;
    
    return 0;
}
int secondPrice(int rank) {
    if (rank == 1) return 5120000;
    else if (rank >= 2 && rank <= 3) return 2560000;
    else if (rank >= 4 && rank <= 7) return 1280000;
    else if (rank >= 8 && rank <= 15) return 640000;
    else if (rank >= 16 && rank <= 31) return 320000;

    return 0;
}

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int cases, a, b;

    cin >> cases;
    for (int i = 0; i < cases; i++) {
        cin >> a >> b;
        cout << firstPrice(a) + secondPrice(b) << "\n";
    }
    return 0;
}
