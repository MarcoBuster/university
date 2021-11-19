#define DONT_MAIN
#include "list_mixins.c"
#undef DONT_MAIN

#include <stdio.h>
#include <stdlib.h>

Node olist_insert(int n, Node l) {
	Node new = malloc(sizeof(Node));
	new->info = n;

	Node curr, prec;
	for (prec = NULL, curr = l; curr != NULL && curr->info < n; curr = curr->next)
		prec = curr;

	new->next = curr;
	if (prec == NULL)
		return new;

	prec->next = new;
	return l;
}

Node olist_search(int n, Node l) {
	for (; l != NULL && l->info < n; l = l->next);
	if (l->info == n)
		return l;
	return NULL;
}

#ifndef DONT_MAIN
int main() {
	Node list = malloc(sizeof(Node));
	list->next = NULL;
	list->info = 15;
	list_insert(10, &list);
	list_insert(8, &list);
	list_insert(3, &list);
	list_print(list);
	list = olist_insert(1, list);
	list_print(list);
	Node res = olist_search(8, list);
	printf("found=%d @ %lx", res->info, (unsigned long int) res);
	return 0;
}
#endif
