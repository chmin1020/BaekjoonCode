#include <iostream>
using namespace std;

int main(){
    int num[5];
    int result = 0;
    
    for(int i = 0; i < 5; i++)
        cin >> num[i];
    
    for(int i = 0; i < 5; i++)
        result += (num[i]*num[i]);
    
    cout << result%10 <<'\n';
    return 0;
}
