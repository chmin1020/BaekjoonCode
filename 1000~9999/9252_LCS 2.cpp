#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>

void calculate(std::string str1, std::string str2) {
	int dp[1001][1001];
	int len = 0, i, j;
	std::string LCS;
	memset(dp, 0, sizeof(dp));

	for (i = 1; i < str1.length(); i++) {
		for (j = 1; j < str2.length(); j++) {
			if (str1[i] == str2[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
			else dp[i][j] = std::max(dp[i - 1][j], dp[i][j - 1]);
		}
	}
	printf("%d\n", dp[str1.length() - 1][str2.length() - 1]);
	
	i = str1.length() - 1, j = str2.length() - 1;

	while (i > 0 && j > 0) {
		if (dp[i][j] == dp[i - 1][j]) i--;
		else if (dp[i][j] == dp[i][j - 1]) j--;
		else {
			LCS.push_back(str2[j]);
			i--; j--;
		}
	}
	if (!LCS.empty()) LCS.insert(LCS.begin(), '\n');
	for (i = LCS.length() - 1; i >= 0; i--)
		printf("%c", LCS[i]);
}
int main() {
	std::string str1, str2;
	std::cin >> str1 >> str2;
	calculate(" " + str1, " " + str2);
	return 0;
}
