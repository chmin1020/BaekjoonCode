#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>

void calculate(std::string str1, std::string str2, std::string str3) {
	int dp[101][101][101];
	int len = 0;
	memset(dp, 0, sizeof(dp));

	for (int i = 1; i < str1.length(); i++) {
		for (int j = 1; j < str2.length(); j++) {
			for (int k = 1; k < str3.length(); k++) {
				if (str1[i] == str2[j] && str1[i] == str3[k] && str2[j] == str3[k]) dp[i][j][k] = dp[i - 1][j - 1][k - 1] +1;
				else dp[i][j][k] = std::max(std::max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
				len = std::max(len, dp[i][j][k]);
			}
		}
	}
	printf("%d\n", len);
}
int main() {
	std::string str1, str2, str3;
	std::cin >> str1 >> str2 >> str3; 
	calculate(" " + str1, " " + str2, " " + str3);
	return 0;
}
