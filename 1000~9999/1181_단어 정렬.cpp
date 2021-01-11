#include <iostream>
#include <cstdio>
#include <cstring>
using namespace std;

class str {
	public: char s[51];
};

void alphabetMergeSort(int left, int right, str words[], str newWords[]) {
	if (left >= right)
		return;

	int mid = (left + right) / 2;
	int i, j, k;

	alphabetMergeSort(left, mid, words, newWords);
	alphabetMergeSort(mid + 1, right, words, newWords);

	for (i = left, j = mid + 1, k = left; (i <= mid) && (j <= right);) {
		if (strcmp(words[i].s, words[j].s) > 0) strcpy(newWords[k++].s, words[j++].s);
		else  strcpy(newWords[k++].s, words[i++].s);
	}
	while (i <= mid)  strcpy(newWords[k++].s, words[i++].s);
	while (j <= right) strcpy(newWords[k++].s, words[j++].s);
	for (i = left; i <= right; i++)  strcpy(words[i].s, newWords[i].s);
}

void lengthMergeSort(int left, int right, str words[], str newWords[]) {
	if (left >= right)
		return;

	int mid = (left + right) / 2;
	int i, j, k;

	lengthMergeSort(left, mid, words, newWords);
	lengthMergeSort(mid + 1, right, words, newWords);

	for (i = left, j = mid + 1, k = left; (i <= mid) && (j <= right);) {
		if (strlen(words[i].s) > strlen(words[j].s))  strcpy(newWords[k++].s, words[j++].s);
		else strcpy(newWords[k++].s, words[i++].s);
	}
	while (i <= mid) strcpy(newWords[k++].s, words[i++].s);
	while (j <= right) strcpy(newWords[k++].s, words[j++].s);
	for (i = left; i <= right; i++) strcpy(words[i].s, newWords[i].s);
}

int main() {
	int num, size;
	
	scanf("%d",&num);
	size = num;

	str *words = new str[num];
	str *newWords = new str[num];

	for (int i = 0; i < num; i++) {
		scanf("%s",words[i].s);
		
		for (int j = 0; j < i; j++) {
			if (strcmp(words[j].s, words[i].s) == 0) {
				i--;
				num--;
				size--;
				break;
			}
		}
	}

	//알파벳 순 정렬
	alphabetMergeSort(0, size - 1, words, newWords);
	
	//문자수 정렬
	lengthMergeSort(0, size - 1, words, newWords);

	for (int i = 0; i < size; i++)
		printf("%s\n",words[i].s);

	delete[]words;
	delete[]newWords;

	return 0;
}
