#include "bitree.c"
#include <string.h>
#include <stdio.h>

typedef char * Key;

int cmp(Key k1, Key k2) {
	return strcmp(k1, k2);
}

Key key(Item i) {
	return i.word;
}

Item bist_search(Bit_node p, Key k) {
	if (!p)
		return BIT_ITEM_NULL;

	int res = cmp(k, key(p->item));
	printf("Ho confrontato k %s con p->item %s e ho trovato %d\n", k, key(p->item), res);

	if (res == 0)
		return p->item;

	if (res < 0)
		return bist_search(p->l, k);

	return bist_search(p->r, k);
}

int bist_searchparent(Bit_node r, Key k, Bit_node *parent, Bit_node *p) {
	int res;
	*parent = NULL;
	*p = r;

	if (!r)
		return -1;

	while (*p && (res = cmp(k, key((*p)->item))) != 0) {
		*parent = *p;
		*p = res < 0 ? (*p)->l : (*p)->r;
	}

	if (*p == NULL)
		return -1;
	return 0;
}

void bist_insert(Bit_node *r, Item item) {
	Bit_node parent;
	Bit_node q = *r;
	Bit_node new_tree = bit_new(item);
	Key k = key(item);

	if (q == NULL) {
		*r = new_tree;
		return;
	}

	if (bist_searchparent(*r, k, &parent, &q) == 0) {
		printf("c'è già\n");
		return;
	}

	if (cmp(k, key(parent->item)) < 0)
		parent->l = new_tree;
	else
		parent->r = new_tree;
}

int bist_delete(Bit_node *r, Key k) {
	Bit_node x, xp, s = NULL;

	if (bist_searchparent(*r, k, &xp, &x) == -1)
		return -1;

	if (x->l == NULL && x->r == NULL)
		s = NULL;
	else if (x->l == NULL || x->r == NULL)
		s = x->l != NULL ? x->l : x->r;
	else {
		Bit_node sp = x;
		s = x->l;
		while (s->r) {
			sp = s;
			s = s->r;
		}

		s->r = x->r;

		if (sp->r == s) {
			sp->r = s->l;
			s->l = x->l;
		}
	}

	if (x == *r)
		*r = s;
	else if (xp->l == x)
		xp->l = s;
	else
		xp->r = s;

	// bit_destroy(x);
	return 0;
}
