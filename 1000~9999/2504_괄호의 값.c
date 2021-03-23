#include <stdio.h>
#include <string.h>
char str[30];

typedef struct {
	char arr[30];
	int pt;
}stack;

long long calc() {
	stack st;
	int len = strlen(str);
	long long ans = 0, tmp = 1;
	char recent=' ';
	int possible = 1;

	st.pt = -1;
	for (int i = 0; i < len; i++) {
		if (str[i] == '(' || str[i] == '[') {
			if (str[i] == '(') tmp *= 2;
			else tmp *= 3;
			st.arr[++st.pt] = str[i];
		}
		else {
			if (st.pt < 0) {
				possible = 0;
				break;
			}
			if (str[i] == ')') {
				if (st.arr[st.pt] != '(') {
					possible = 0;
					break;
				}
				if (recent != ')' && recent != ']') ans += tmp;
				tmp /= 2;
			}
			else if (str[i] == ']') {
				if (st.arr[st.pt] != '[') {
					possible = 0;
					break;
				}
				if (recent != ')' && recent != ']') ans += tmp;
				tmp /= 3;
			}
			else
				break;
			st.pt--; //pop
		}
		recent = str[i];
	}
	if (st.pt == -1 && possible == 1) return ans;
	return 0;
}

int main() {
	scanf("%s", str);
	printf("%lld\n", calc());
	return 0;
}
