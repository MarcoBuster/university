#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define N 100

void treVolte(char *a[], int n ) {
	// char **p, *q = (char *) malloc(N * sizeof(char));
	char **p, q[N];
	int conta = 0;

	for (p = a; p < a + n; p++) {
		int contae = 0;
		char *c;
		c = *p;

		while (*c) {
			if (*c == 'e') {
				contae++;
			}
			if (contae == 3) {
				conta++;
				break;
			}
			c++;
		}
		if (conta == 3) {
			strcpy(q, *p);
			strcpy(*p, a[0]);
			strcpy(a[0], q);
			return;
		}
	}
}

int main(int argc, char **argv) {
	treVolte(argv + 1, argc - 1);

	for (char **p = argv + 1; p < argv + argc; p++)
		printf("%s ", *p);
	printf("\n");
}

