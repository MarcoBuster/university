/*
 * https://lonati.di.unimi.it/algopig/2122/materiale/L05_2-registro.pdf
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void *my_malloc(size_t size) {
	void *ptr = malloc(size);
	if (ptr == NULL) {
		printf("Memory error\n");
		exit(1);
	}
	// printf("%d bytes allocated @ %x\n", size, ptr);
	return ptr;
}

void newBook(char ***registry, int n) {
	if (*registry != NULL)
		free(*registry);
	*registry = my_malloc(n * sizeof(char *));
	for (int i = 0; i < n; i++) {
		(*registry)[i] = NULL;
	}
}

void book(char **registry, int k, char *name) {
	char **ptr = registry+k;
	if (*ptr != NULL) {
		printf("Error: entry #%d is already booked!\n", k);
		return;
	}
	*ptr = my_malloc((strlen(name) + 1) * sizeof(char));
	strcpy(*ptr, name);
}

void cancel(char **registry, int k) {
	char **ptr = registry+k;;
	if (*ptr == NULL) {
		printf("Error: entry #%d is empty!\n", k);
		return;
	}
	*ptr = NULL;
}

void move(char **registry, int from, int to) {
	char **from_ptr = registry+from;
	if (*from_ptr == NULL) {
		printf("Error: source entry %d is empty!\n", from);
		return;
	}
	char **to_ptr = registry+to;
	if (*to_ptr != NULL) {
		printf("Error: destination entry %d is already booked!\n", to);
		return;
	}
	*to_ptr = *from_ptr;
	*from_ptr = NULL;
}

void printBook(char **registry, int n) {
	printf("\nREGISTER[0..9]:\n");
	for (int i = 0; i < n; i++) {
		char *entry = *(registry+i);
		if (entry != NULL) {
			printf("%d --> %s\n", i, entry);
		}
	}
}

int main() {
	char **registry = NULL;
	char c;
	int n;
	int k;
	int from, to;
	while ((c = getchar()) != 'f') {
		switch (c) {
			case 'b':
				scanf(" %d", &n);
				newBook(&registry, n);
				break;
			case '+':
				scanf(" %d ", &k);
				char entryC, *entry;
				entry = malloc(1 * sizeof(char));
				for (int size = 0; (entryC = getchar()) != '\n'; size++) {
					entry[size] = entryC;
					entry = realloc(entry, size+1);
				}
				book(registry, k, entry);
				break;
			case '-':
				scanf(" %d", &k);
				cancel(registry, k);
				break;
			case 'm':
				scanf(" %d ", &from);
				scanf(" %d", &to);
				move(registry, from, to);
				break;
			case 'p':
				printBook(registry, n);
				break;
		}
	}
	return 0;
}
