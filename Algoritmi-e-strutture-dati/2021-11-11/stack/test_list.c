#include "stack_list.c"
#include <stdio.h>
#include <stdlib.h>

int main() {
	push(10);
	push(20);
	push(30);
	print_stack();
	printf("top(): %d\n", top());
	print_stack();
	printf("pop(): %d\n", pop());
	print_stack();
	printf("pop(): %d\n", pop());
	print_stack();
	printf("push(%d)\n", 15);
	push(15);
	print_stack();
	make_empty();
	print_stack();
	return 0;
}
