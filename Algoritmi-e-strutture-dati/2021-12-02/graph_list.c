/*
 * LICENSE NOTICE
 * Source code: Copyright (c) Marco Aceti, 2021. MIT license.
 * Docstrings: Copyright (c) Violetta Lonati, 2021. All rights reserved. 
 */

#include "graph.h"
#define DONT_MAIN
#include "queue.c"
#undef DONT_MAIN
#include <stdlib.h>
#include <stdio.h>
#include <time.h>

struct listnode {
	struct listnode *next;
	int v;
};
typedef struct listnode *ListNode;

struct graph {
	int n, m;
	struct listnode **A;
};

ListNode list_search(ListNode l, int v) {
	for (; l != NULL && l->v != v; l = l->next);
	return l;
}

ListNode list_insert(ListNode l, int v) {
	// printf("list_insert call(l@0x%lx, %d)\n", (long unsigned int) l, v);
	ListNode new = malloc(sizeof(struct listnode));
	new->v = v;
	new->next = l;
	return new;
}

Graph graph_new(int n) {
	Graph g;
	g = malloc(sizeof(struct graph));
	g->A = calloc(n, sizeof(struct listnode *));
	for (int i = 0; i < n; i++)
		g->A[i] = NULL;
	g->n = n;
	g->m = 0;
	return g;
}

void graph_destroy(Graph g) {
	int i;
	for (i = 0; i < g->n; i++) {
		if (g->A[i] == NULL)
			continue;
		free(g->A[i]);
	}
	free(g->A);
	free(g);
}

bool path(Graph g, int v, int w) {
	ListNode v_node = g->A[v];
	for (; v_node != NULL && v_node->v != w; v_node = v_node->next);
	return v_node != NULL;
}

void graph_edgeinsert(Graph g, int v, int w) {
	if (path(g, v, w))  // L'arco è già presente nel grafo
		return;

	g->A[v] = list_insert(g->A[v], w);
	g->A[w] = list_insert(g->A[w], v);
	g->m++;
}

Graph graph_read() {
	int n;
	printf("n? ");
	scanf("%d", &n);
	Graph g = graph_new(n);

	int v, w;
	while (1) {
		scanf("%d", &v);
		scanf("%d", &w);
		if (v >= n || w >= n) {
			printf("! error\n");
			continue;
		}
		if (v == -1 || w == -1)
			break;
		printf("%d <-> %d\n", v, w);
		graph_edgeinsert(g, v, w);
	}
	return g;
}

void node_visit(int v) {
	printf("visited node %d\n", v);
	// other actions?
}

void graph_print(Graph g) {
	int i;
	for (i = 0; i < g->n; i++) {
		printf("g->A[%d] @0x%lx\t", i, (long unsigned int) g->A[i]);
		for (ListNode curr = g->A[i]; curr != NULL; curr = curr->next)
			printf("%d ", curr->v);
		printf("\n");
	}

	// printed è una matrice che contiene gli archi già stampati
	int *printed[g->n];
	// alloca e riempi con tutti zeri la matrice
	for (i = 0; i < g->n; i++)
		printed[i] = calloc(g->n, sizeof(int));

	// stampa
	for (i = 0; i < g->n; i++) {
		for (ListNode curr = g->A[i]; curr != NULL; curr = curr->next) {
			// se già stampato ignora
			if (printed[curr->v][i])  
				continue;
			printed[i][curr->v] = 1;
			printf("%d <-> %d\n", i, curr->v);
		}
	}

	// dealloca la matrice
	for (i = 0; i < g->n; i++)
		free(printed[i]);
}

/*
 * Visita il grafo con DFS (Depth-First search)
 */
void graph_dfs1(Graph g, int v, int *visited) {
	visited[v] = 1;
	for (int j = 0; j < g->n; j++) {
		if (visited[j] || !list_search(g->A[v], j))
			continue;

		node_visit(j);
		graph_dfs1(g, j, visited);
	}
}
void graph_dfs(Graph g, int v) {
	int *visited = calloc(g->n, sizeof(int));
	node_visit(v);
	graph_dfs1(g, v, visited);
}

/*
 * Visita il grafico in BFS (Breadth-First search)
 */
void graph_bfs(Graph g, int v) {
	int *visited = calloc(g->n, sizeof(int));
	Queue q;
	init_queue(&q);

	enqueue(&q, v);
	while (!is_empty(q)) {
		int u = dequeue(&q);
		node_visit(u);
		visited[u] = 1;

		// visita i figli di u
		for (int j = 0; j < g->n; j++) {
			if (visited[j] || !list_search(g->A[u], j))
				continue;

			visited[j] = 1;
			enqueue(&q, j);
		}
	}
}

/*
 * gen (p) genera un grafo casuale, a partire dalla probabilità p compresa tra 0 e 1 (inclusi).
 * Il modello matematico di riferimento è il seguente: si considerano tutti i possibili archi includendoli nel grafo con probabilità p. 
 * Più esplicitamente, per ogni possibile coppia di vertici, si genera un numero reale compreso tra 0 e 1; 
 * se questo è minore di p si inserisce l’arco, altrimenti non lo si inserisce.
 */
void gen(Graph g, float p) {
	srand(time(NULL));
	float r;
	for (int i = 0; i < g->n; i++) {
		for (int j = 0; j < g->n; j++) {
			if (i == j)
				continue;
			r = (float) rand() / RAND_MAX;
			if (r >= p)
				continue;
			graph_edgeinsert(g, i, j);
		}
	}
}

/*
 * degree (v) calcola il grado del vertice v.
 * Si ricorda che il grado di un vertice è definito come il numero di vertici ad esso adiacenti.
 */
int degree(Graph g, int v) {
	int count = 0;
	for (ListNode curr = g->A[v]; curr != NULL; curr = curr->next)
		count++;
	return count;
}

/*
 */
int ccc_bfs(Graph g, int v, int *visited) {
	Queue q;
	init_queue(&q);

	int count = 0;
	enqueue(&q, v);
	while (!is_empty(q)) {
		int u = dequeue(&q);
		node_visit(u);
		visited[u] = 1;

		for (int j = 0; j < g->n; j++) {
			if (visited[j] || !list_search(g->A[u], j))
				continue;

			visited[j] = 1;
			enqueue(&q, j);
			count++;
		}
	}
	return count;
}
int ccc(Graph g) {
	int result = 0;
	int *visited = calloc(g->n, sizeof(int));
	for (int i = 0; i < g->n; i++) {
		visited[i] = 1;
		if (ccc_bfs(g, i, visited) != 0)
			result++;
	}
	return result;
}

void cc(Graph g, int v) {
	/*
	 * -----------------------------------
	 * !!!!!!!!!!!!! BROKEN !!!!!!!!!!!!!!
	 *         don't ever use this
	 * -----------------------------------
	 * PROBABLY BROKEN ON MATRIX IMPL. TOO
	 * -----------------------------------
	 * !!!!!!!!!!!!! BROKEN !!!!!!!!!!!!!!
	 *         don't ever use this
	 * -----------------------------------
	 */
	printf("\n");
	return -69420;
	int *connected = calloc(g->n, sizeof(int));
	int connections = 0;
	
	// Itera tutti i nodi connessi a v e li conta
	for (ListNode node = g->A[v]; node != NULL; node = node->next) {
		if (v == node->v)
			continue;

		connected[node->v] = 1;
		connections++;
	}

	// printf("# connections to v: %d\n", connections);

	int node_connections;
	for (ListNode n1 = g->A[v]; n1 != NULL; n1 = n1->next) {
		// printf("iterating node %d\n", n1->v);
		if (n1->v == v)
			continue;
		
		node_connections = 0;
		for (ListNode n2 = g->A[v]; n2 != NULL; n2 = n2->next) {
			if (!connected[n2->v] || n1->v == n2->v || !path(g, n1->v, n2->v))
				continue;
			node_connections++;
		}
		// printf("which has %d connections\n", node_connections);
		if (node_connections == connections-1)
			printf("%d ", n1->v);
	}
	printf("\n");
}

int main() {
	Graph g = graph_new(10);
	// graph_destroy(g);
	graph_edgeinsert(g, 1, 2);
	graph_edgeinsert(g, 3, 4);
	graph_edgeinsert(g, 0, 1);
	graph_edgeinsert(g, 0, 2);
	graph_edgeinsert(g, 0, 3);
	graph_print(g);
	// graph_destroy(g);
	// g = graph_read();
	// graph_print(g);
	printf("\n-----(graph_dfs)-----\n\n");
	graph_dfs(g, 0);
	printf("\n-----(graph_bfs)-----\n\n");
	graph_bfs(g, 0);
	graph_destroy(g);
	g = graph_new(10);
	gen(g, 0.2);
	graph_print(g);
	printf("degree(1)=%d\n", degree(g, 1));
	printf("ccc=%d\n", ccc(g));
	printf("cc(g, 0): "); cc(g, 0);
	return 0;
}
