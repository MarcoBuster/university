#include <stdio.h>
#include <stdlib.h>
#include "bitree.h"

Bit_node bit_new(Item i) {
	Bit_node bit = malloc(sizeof(struct bit_node));
	bit->item = i;
	bit->l = NULL;
	bit->r = NULL;
	return bit;
}

void bit_printnode(Bit_node p) {
#ifndef BIT_ITEM_TYPE_OCCORRENZA
	printf("%d\n", p->item);
#endif
#ifdef BIT_ITEM_TYPE_OCCORRENZA
	printf("%s (%d)\n", p->item.word, p->item.n);
#endif
}

void bit_preorder(Bit_node p) {
	if (p) {
		bit_printnode(p);
		bit_preorder(p->l);
		bit_preorder(p->r);
	}
}
void bit_inorder(Bit_node p) {
	if (p) {
		bit_inorder(p->l);
		bit_printnode(p);
		bit_inorder(p->r);
	}
}
void bit_postorder(Bit_node p) {
	if (p) {
		bit_postorder(p->l);
		bit_postorder(p->r);
		bit_printnode(p);
	}
}

void bit_printassummary(Bit_node p, int spaces) {
	if (p) {
		for (int i = 0; i < spaces; i++)
			printf(" ");
		printf("*"); bit_printnode(p);
		bit_printassummary(p->l, spaces+1);
		bit_printassummary(p->r, spaces+1);
	}
}

Bit_node bit_arr2tree(Item a[], int size, int i) {
	if (i >= size) {
		return NULL;
	}
	Bit_node radix = bit_new(a[i]);
	radix->l = bit_arr2tree(a, size, i*2+1);
	radix->r = bit_arr2tree(a, size, i*2+2);
	return radix;
}

