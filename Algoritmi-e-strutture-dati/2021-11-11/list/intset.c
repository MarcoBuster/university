#include "list.c"
#include <stdio.h>

Node set_insert(Node l, int n, int *counter) {
	*counter = *counter+1;
	Node new = malloc(sizeof(Node));
	new->info = n;
	new->next = NULL;
	if (l == NULL)
		return new;

	new->next = l;
	return new;
}

Node set_delete(Node l, int n, int *counter) {
	Node curr, prev = NULL;
	if (l == NULL)
		return l;

	for (curr = l; curr->next != NULL && curr->info != n; curr = curr->next)
		prev = curr;

	if (curr->info != n)  // element not found
		return l;

	*counter = *counter-1;
	if (prev == NULL) {
		curr = l->next;
		free(l);
		return curr;
	}
	prev->next = curr->next;
	free(curr);
	return l;
}

void set_memberof(Node l, int n) {
	for (; l != NULL; l = l->next) {
		if (l->info == n) {
			printf("%d is a member of the set\n", n);
			return;
		}
	}
	printf("%d is not a member of the set\n", n);
}

void set_print(Node l) {
	if (l == NULL) {
		printf("\n");
		return;
	}
	printf("%d ", l->info);
	return set_print(l->next);
}

Node set_deleteall(Node l, int *counter) {
	Node next;
	while (l != NULL) {
		next = l->next;
		free(l);
		l = next;
	}
	*counter = 0;
	return l;
}

#ifndef DONT_MAIN
int main() {
	Node set = NULL;

	int n;
	int counter = 0;
	char c;
	while ((c = getchar()) != 'f') {
		switch (c) {
			case '+':
				scanf(" %d", &n);
				set = set_insert(set, n, &counter);
				break;
			case '-':
				scanf(" %d", &n);
				set = set_delete(set, n, &counter);
				break;
			case '?':
				scanf(" %d", &n);
				set_memberof(set, n);
				break;
			case 'c':
				printf("%d\n", counter);
				break;
			case 'p':
				set_print(set);
				break;
			case 'd':
				set = set_deleteall(set, &counter);
				break;
		}
	}
	return 0;
}
#endif
