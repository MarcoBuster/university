#include "stack.h"
#include "item.h"
#include <stdio.h>
#include <stdlib.h>

#define MAX_LENGTH 100

typedef Item StackArray[MAX_LENGTH];
typedef int StackIdx;

StackArray s = {};
int stack_idx = -1;

void make_empty() {
	stack_idx = -1;
}

int is_empty() {
	return stack_idx == -1 ? 1 : 0;
}

int is_full() {
	return stack_idx+1 == MAX_LENGTH ? 1 : 0;
}

Item top() {
	if (is_empty()) {
		printf("can't top(): the pile is empty!\n");
		exit(1);
	}
	return s[stack_idx];
}

Item pop() {
	if (is_empty()) {
		printf("can't pop(): the pile is empty!\n");
		exit(1);
	}
	return s[stack_idx--];
}

void push(Item n) {
	if (is_full()) {
		printf("can't push(): the pile is full!\n");
		exit(1);
	}
	s[++stack_idx] = n;
}

void print_stack() {
	for (int i = stack_idx; i >= 0; i--)
		printf("%d ", s[i]);
	printf("\n");
}
