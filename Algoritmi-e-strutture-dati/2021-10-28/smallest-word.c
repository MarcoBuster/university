#include <stdio.h>
#include <string.h>

typedef char * String;

int smallest_word_index(String s[], int n) {
	String smallest = s[0];
	int smallest_idx = 0;
	for (int i = 1; i < n; i++) {
		if (strcmp(smallest, s[i]) > 0) {
			smallest = s[i];
			smallest_idx = i;
		}
	}
	return smallest_idx;
}

String *smallest_word_address(String s[], int n) {
	String *smallest = &s[0];
	for (int i = 1; i < n; i++) {
		if (strcmp(*smallest, s[i]) > 0) {
			smallest = &s[i];
		}
	}
	return smallest;
}

int main() {
	char *dict[] = { "ciao", "mondo", "come", "funziona", "bene", "il", "programma" };
	int lun = 7;
	printf("%d\n", smallest_word_index(dict, lun));
	printf("%s\n", *smallest_word_address(dict, lun));
	return 0;
}
