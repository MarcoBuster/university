#ifndef BIT_HEADER
#define BIT_HEADER

#ifndef BIT_ITEM_TYPE
#define BIT_ITEM_TYPE int
#endif
typedef BIT_ITEM_TYPE Item;
#ifndef BIT_ITEM_NULL
#define BIT_ITEM_NULL (Item) NULL
#endif

struct bit_node {
	Item item;
	struct bit_node *l;
	struct bit_node *r;
};
typedef struct bit_node *Bit_node;

Bit_node bit_new(Item);
void bit_printnode(Bit_node);
void bit_preorder(Bit_node);
void bit_inorder(Bit_node);
void bit_postorder(Bit_node);
void bit_printassummary(Bit_node, int);
Bit_node bit_arr2tree(Item *, int, int);
#endif
