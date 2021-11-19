#include "stack.h"
#include "stack_list.c"
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

enum CharType {
	NUMBER,
	OPERATOR,
	BRACKET_OPEN,
	BRACKET_CLOSE,
	OTHER,
};

enum CharType dispatch(char c) {
	if (isdigit(c))
		return NUMBER;
	if (c == '+' || c == '-' || c == '*' || c == '/')
		return OPERATOR;
	if (c == '(')
		return BRACKET_OPEN;
	if (c == ')')
		return BRACKET_CLOSE;
	return OTHER;
}

int main() {
	char token;
	while ((token = getchar()) != '\n') {
		switch (dispatch(token)) {
			case NUMBER:
				printf("%c ", token);
				break;

			case OPERATOR:
				push(token);
				break;

			case BRACKET_OPEN:
			case OTHER:
				break;

			case BRACKET_CLOSE:
				printf("%c ", pop());
				break;
		}
	}
}
