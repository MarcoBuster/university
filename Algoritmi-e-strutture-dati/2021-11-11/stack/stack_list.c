#include "stack.h"
#include "item.h"
#include <stdio.h>
#include <stdlib.h>

struct node {
	Item info;
	struct node *next;
};
typedef struct node * Node;

Node head = NULL;

void make_empty() {
	head = NULL;
}

int is_empty() {
	return head == NULL ? 1 : 0;
}

int is_full() {
	return 0;
}

Item top() {
	if (head == NULL) {
		printf("can't top(): the pile is empty!\n");
		exit(1);
	}
	return head->info;
}

Item pop() {
	if (head == NULL) {
		printf("can't pop(): the pile is empty!\n");
		exit(1);
	}
	Item res = top();
	Node old_head = head;
	head = head->next;
	free(old_head);
	return res;
}

void push(Item n) {
	Node new = malloc(sizeof(Node));
	new->info = n;
	new->next = head;
	head = new;
}

void print_stack() {
	for (Node l = head; l != NULL; l = l->next)
		printf("%d ", l->info);
	printf("\n");
}
