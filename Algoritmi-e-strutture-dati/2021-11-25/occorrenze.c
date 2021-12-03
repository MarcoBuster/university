#include <stdio.h>
#include <string.h>

struct occorrenza {
	char *word;
	int n;
};

#define BIT_ITEM_TYPE struct occorrenza
#define BIT_ITEM_TYPE_OCCORRENZA
#define BIT_ITEM_NULL (Item) {NULL, -1}
#include "bistree.c"

char *read_word() {
	char *word = malloc(sizeof(char));
	char c;
	for (int i = 0; (c = getchar()) != '\n'; i++) {
		word = realloc(word, (i+1) * sizeof(char));
		word[i] = c;
	}
	return word;
}

void bist_orderprint(Bit_node p) {
	if (p) {
		bist_orderprint(p->l);
		bit_printnode(p);
		bist_orderprint(p->r);
	}
}

void bist_invorderprint(Bit_node p) {
	if (p) {
		bist_orderprint(p->r);
		bit_printnode(p);
		bist_orderprint(p->l);
	}
}

int main() {
	const char stop[4] = {'S', 'T', 'O', 'P'};
	char *word = read_word();
	Bit_node radix = bit_new((struct occorrenza) {word, 1});

	Item occorr;
	while (strcmp(word, stop) != 0) {
		occorr =  bist_search(radix, word);
		if (occorr.n == -1)  // BIT_ITEM_NULL, not found
			occorr = (struct occorrenza) {word, 1};
		else
			occorr.n++;
		bist_delete(&radix, word);
		bist_insert(&radix, occorr);
		word = read_word();
	}

	bit_printassummary(radix, 0);
	bist_orderprint(radix);
	return 0;
}
