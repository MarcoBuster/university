#include <stdio.h>
#include <ctype.h>

#define MAX_LENGTH 256

char *maiuscolo(char *stringa) {
	for (char *i = stringa; *i != '\0'; i += sizeof(char))
		*i = toupper(*i);
	
	return stringa;
}

int main() {
	char c, s[MAX_LENGTH] = {};

	for (int i = 0; (c = getchar()) != '\n' && i < MAX_LENGTH; i++)
		s[i] = c;

	maiuscolo(s);
	printf("%s", s);
	return 0;
}
