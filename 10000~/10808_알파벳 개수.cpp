#include <stdio.h>
#include <string.h>

int main() {
	int alphabet[26];
	char input[101];
	memset(alphabet, 0, sizeof(alphabet));

	scanf("%s", input);
	for (int i = 0; i < strlen(input); i++)
		alphabet[input[i] - 'a']++;
	for (int i = 0; i < 26; i++)
		printf("%d ", alphabet[i]);
	printf("\n");
	return 0;
}
