#include "list.c"
#include <stdlib.h>
#include <stdio.h>

void list_insert(int n, Node *l) {
	Node new = malloc(sizeof(Node));
	new->info = n;
	new->next = *l;
	*l = new;
}

Node list_search(int n, Node l) {
	for (; l != NULL && l->info != n; l = l->next);
	return l;
}

Node list_search_rec(int n, Node l) {
	if (l->info == n || l == NULL)
		return l;
	return list_search_rec(n, l->next);
}

void list_delete(int n, Node *l) {
	Node curr, prev;
	for (curr = *l, prev = NULL; curr != NULL; prev = curr, curr = curr->next) {
		if (curr->info == n)
			break;
	}
	if (curr == NULL)				// l'elemento non è nella lista
		return;
	if (prev == NULL) {				// l'elemento da cancellare è il primo
		*l = (*l)->next;
	}
	else							// l'elemento da cancellare non è il primo
		prev->next = curr->next;	// curr viene eliminato
	free(curr);
}

void list_print(Node l) {
	printf("%d ", l->info);
	return l->next != NULL ? list_print(l->next) : printf("\n");
}

void list_printInv(Node l) {
	if (l == NULL)
		return;
	list_printInv(l->next);
	printf("%d ", l->info);
}

int* listToArray(Node l) {
	int *a;
	for (int i = 0; l != NULL; i++) {
		a = realloc(a, i * sizeof(int));
		*(a+i) = l->info;
		l = l->next;
	}
	return a;
}

void list_destroy(Node l) {
	if (l == NULL)
		return;
	Node old = l;
	l = l->next;
	free(old);
	list_destroy(l);
}

#ifndef DONT_MAIN
int main() {
	Node list = malloc(sizeof(Node));
	list->info = 7;
	list->next = NULL;
	list_insert(5, &list);
	list_insert(2, &list);
	list_insert(1, &list);
	list_insert(3, &list);
	Node res = list_search_rec(2, list);
	printf("found=%d @ %lx\n", res->info, (long unsigned int) res);
	list_print(list);
	list_delete(7, &list);
	list_print(list);
	list_printInv(list);
	printf("\n\n");
	int *arr;
	arr = listToArray(list);
	for (int i = 0; i < 4; i++)
		printf("%d ", arr[i]);
	printf("\n");
	list_destroy(list);
}
#endif
