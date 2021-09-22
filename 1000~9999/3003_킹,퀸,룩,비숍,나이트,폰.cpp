#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL); cout.tie(NULL);
    ios_base::sync_with_stdio(false);

    int standard[6] = { 1,1,2,2,2,8 },
        input[6], answer[6];
    
    for (int i = 0; i < 6; i++) {
        cin >> input[i];
        answer[i] = standard[i] - input[i];
    }
    for (int i = 0; i < 6; i++)
        cout << answer[i] << " ";
    return 0;
}
