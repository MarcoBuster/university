#include "stack.h"
#include "stack_list.c"
#include <stdbool.h>

const char OPEN_BRACKET = '<';
const char CLOSE_BRACKET = '>';
const char CLOSE_TAG = '/';

int main() {
	char c;
	char prev, opening_tag;
	bool closing = false;
	while ((c = getchar()) != '\n') {
		if (c == ' ')
			continue;

		if (c == OPEN_BRACKET)
			closing = false;

		// opening tag
		if (c == CLOSE_BRACKET && !closing) {
			push(prev);
		}
		// closing tag
		else if (prev == CLOSE_TAG) {
			opening_tag = pop();
			if (c != opening_tag) {
				printf("il documento non è ben formato\n");
				exit(0);
			}
			closing = true;
		}

		prev = c;
	}

	if (is_empty())
		printf("Il documento è ben formato\n");
	else
		printf("Il documento non è ben formato\n");
	return 0;
}
