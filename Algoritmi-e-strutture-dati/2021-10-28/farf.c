#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>

#define MAX 100
#define CHAR_SIZE sizeof(char)

bool vocale(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

char *farfallino(char *word, char result[MAX]) {
	char *res_ptr = result;
	char *end = word + strlen(word) * CHAR_SIZE;

	for (char *p = word; p < end; p += CHAR_SIZE) {
		if (!vocale(*p)) {
			*res_ptr = *p;
		} else {
			*res_ptr = *p;
			*(res_ptr += CHAR_SIZE) = 'f';
			*(res_ptr += CHAR_SIZE) = *p;
		}
		res_ptr += CHAR_SIZE;
	}
	return result;
}

int main(int argc, char **argv) {
	if (argc < 2)
		return 1;

	char *word = argv[1];
	char result[MAX] = {};

	printf("%s", farfallino(word, result));
	return 0;
}
