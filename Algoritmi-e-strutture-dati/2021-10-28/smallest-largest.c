#include <stdio.h>
#include <string.h>

void smallest_largest(char *s[], int n, char **smallest, char **largest) {
	*smallest = s[0];
	*largest = s[0];
	for (int i = 0; i < n; i++) {
		if (strcmp(s[i], *smallest) < 0)
			*smallest = s[i];
		if (strcmp(s[i], *largest) > 0)
			*largest = s[i];
	}
}

int main() {
	char *dict[] = { "ciao", "mondo", "come", "funziona", "bene", "il", "programma" };
    int lun = 7;

	char *smallest, *largest;
	smallest_largest(dict, lun, &smallest, &largest);
	printf("smallest=%s\n", smallest);
	printf("largest=%s\n", largest);
	return 0;
}
