#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *read_line(char end) {
	char *result;
	int size = 0;
	result = malloc(size);
	if (result == NULL)
		return result;

	char c;
	while ((c = getchar()) != end) {
		result[size] = c;
		size++;
		result = realloc(result, size);
	}
	return result;
}

int main() {
	char *s = read_line('b');

	printf("%s\n", s);
	return 0;
}
