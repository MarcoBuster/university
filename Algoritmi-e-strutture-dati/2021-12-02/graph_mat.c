/*
 * LICENSE NOTICE
 * Source code: Copyright (c) Marco Aceti, 2021. MIT license.
 * Docstrings: Copyright (c) Violetta Lonati, 2021. All rights reserved.
 * https://lonati.di.unimi.it/algopig/2122/materiale/L09-grafi-implementazione.pdf
 */
 
struct graph {
	int n, m;
	int **A;
};

#include "graph.h"
#define DONT_MAIN
#include "queue.c"
#undef DONT_MAIN
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

#ifdef DONT_PRINT_ANYTHING
// Disable printf globally; useful for performance measurements.
extern int printf(const char *__restrict __format, ...) {
	return 0;
}
#endif

Graph graph_new(int n) {
	Graph g;
	g = malloc(sizeof(struct graph));
	g->A = calloc(n, sizeof(int *));
	for (int i = 0; i < n; i++)
		g->A[i] = calloc(n, sizeof(int));
	g->n = n;
	g->m = 0;
	return g;
}

void graph_destroy(Graph g) {
	for (int i = 0; i < g->n; i++) {
		free(g->A[i]);
	}
	free(g->A);
	free(g);
}

void graph_edgeinsert(Graph g, int v, int w) {
	g->A[v][w] = 1;
	g->A[w][v] = 1;
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
	};
	return g;
}

void graph_print(Graph g) {
	for (int i = 0; i < g->n; i++) {
		for (int j = i; j < g->n; j++) {
			if (g->A[i][j] == 0)
				continue;
			printf("%d <-> %d\n", i, j);
		}
	}
}

/*
 * Visita un nodo
 */
void node_visit(int v) {
	printf("visited node %d\n", v);
	// other actions?
}

/*
 * Visita il grafo con DFS (Depth-First search)
 */
void graph_dfs1(Graph g, int v, int *visited) {
	visited[v] = 1;
	for (int j = 0; j < g->n; j++) {
		if (visited[j] || !g->A[v][j])
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
 * Visita il grafo in BFS (Breadth-First search)
 */
void graph_bfs(Graph g, int v) {
	int *visited = calloc(g->n, sizeof(int));
	Queue q;
	init_queue(&q);
	// v è aperto
	enqueue(&q, v);
	while (!is_empty(q)) {
		// u è chiuso
		int u = dequeue(&q);
		node_visit(u);

		// visita i figli di u
		for (int j = 0; j < g->n; j++) {
			if (!g->A[u][j] || visited[j])
				continue;

			// v è aperto
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
	for (int j = 0; j < g->n; j++) {
		if (g->A[v][j])
			count++;
	}
	return count;
}

/*
 * path(v, w) testa l’esistenza di un cammino semplice che collega i vertici v e w.
 * Si ricorda che un cammino si dice semplice quando attraversa ogni vertice al più una volta il numero di vertici ad
esso adiacenti.
 */
bool path(Graph g, int v, int w) {
	return g->A[v][w] || g->A[w][v];
}

/*
 * Visita il grafo in BFS (Breadth-First search),
 * marca i nodi come visitati quando lo sono e ritorna il conteggio dei nodi visitati.
 * Funzione di utilità per ccc e cc.
 */
int ccc_bfs(Graph g, int v, int *visited) {
	int count = 0;
	Queue q;
	init_queue(&q);
	enqueue(&q, v);
	while (!is_empty(q)) {
		int u = dequeue(&q);
		node_visit(u);

		for (int j = 0; j < g->n; j++) {
			if (!g->A[u][j])
				continue;

			visited[j]++;
			if (visited[j] > 1)
				continue;

			count++;
			enqueue(&q, j);
		}
	}
	return count;
}
/*
 * ccc conta il numero di componenti connesse di un grafo.
 * Si ricorda che si chiama componente connessa di un grafo ogni insieme massimale di vertici connessi tra loro da un cammino.
 */
int ccc(Graph g) {
	int result = 0;

	int *visited = calloc(g->n, sizeof(int));
	for (int i = 0; i < g->n; ++i) {
		visited[i] = 1;
		if (ccc_bfs(g, i, visited) != 0)
			result++;
	}
	return result;
}

/*
 * cc (v) stampa l’elenco dei vertici della componente fortemente connessa contenente v;
 */
void cc(Graph g, int v) {
	// Trovo tutti i nodi connessi a v
	int *connected = calloc(g->n, sizeof(int));
	// e conto il numero di connessioni a v
	int connections = 0;
	for (int j = 0; j < g->n; j++) {
		if (v == j || !path(g, v, j))
			continue;

		// j è connesso a v
		connected[j] = 1;
		connections++;
	}

	// Itera tutti i nodi connessi a v
	int node_connections;
	printf("cc nodes: %d ", v);
	for (int j1 = 0; j1 < g->n; j1++) {
		if (!connected[j1])
			continue;

		// Conta il numero di connessioni del nodo considerato
		node_connections = 0;
		for (int j2 = 0; j2 < g->n; j2++) {
			// Se il secondo nodo considerato:
			// 	- non è connesso a v
			// 	- è uguale al primo nodo considerato
			// 	- non è collegato al primo nodo considerato
			// non contarlo, altrimenti contalo
			if (!connected[j2] || j1 == j2 || !path(g, j1, j2))
				continue;
			node_connections++;
		}
		// Se il numero di connessioni del nodo iterato è uguale
		// al numero dei nodi connessi a v (-1, ovvero il nodo stesso)
		// allora il nodo considerato è fortemente connesso
		if (node_connections == connections-1)
			printf("%d ", j1);
	}
	printf("\n");
}

/*
 * span (v) calcola uno spanning tree con radice v e lo stampa nella rappresentazione "a sommario";
 * Si ricorda che si definisce spanning tree (in italiano, albero di copertura) un albero che ha per nodi tutti e soli vertici del grafo. 
 * Osservate che per ottenere uno spanning tree con radice v è sufficiente eseguire una visita della componente connessa contenente v stampando ad ogni passo l’arco attraversato. 
 * Che tipo di visita si deve eseguire per avere la garanzia di ottenere uno spanning tree di altezza minimale?
 */
// Utilizzo la ricerca DFS ricorsiva modificata per generare un grafo ricoprente di altezza minimale.
void span1(Graph g, Graph *res, int i, int *visited) {
	for (int j = 0; j < g->n; j++) {
		if (!g->A[i][j] || visited[j])
			continue;

		// j è collegato con v
		// è la prima volta che vedo j con i
		graph_edgeinsert(*res, i, j);
		visited[j] = 1;
		node_visit(j);
		span1(g, res, j, visited);
	}
}
Graph span(Graph g, int v) {
	Graph res = graph_new(g->n);
	int *visited = calloc(g->n, sizeof(int));
	span1(g, &res, v, visited);
	return res;
}

/*
 * shortestpath (v, w) calcola il cammino più breve che collega i vertici v e w.
 */
void follow_prec(int *prec, int v, int i, int *length) {
	printf("%d ", i);
	if (i == v) {
		printf("\n");
		return; 
	}
	(*length)++;
	follow_prec(prec, v, prec[i], length);
}
int shortestpath(Graph g, int v, int w) {
	int *prec = calloc(g->n, sizeof(int));

	// visita BFS, modificata per salvare il cammino precedente ad ogni elemento visitato
	int *visited = calloc(g->n, sizeof(int));
	Queue q;
	init_queue(&q);
	enqueue(&q, v);
	while (!is_empty(q)) {
		int u = dequeue(&q);

		for (int j = 0; j < g->n; j++) {
			int node = g->A[u][j];
			if (!node || visited[j])
				continue;

			visited[j] = 1;
			prec[j] = u;  // salva il cammino per l'elemento
			if (j == w)
				goto PathFound;

			enqueue(&q, j);
		}
	}
	printf("no path found.\n");
	return -1;

PathFound:
	printf("found path: ");
	int length = 0;
	follow_prec(prec, v, w, &length);
	return length;
}

/*
 * twocolor testa se il grafo è bicolorabile.
 * Si ricorda che un grafo si dice bicolorabile quando è possibile assegnare ad ogni vertice del grafo uno dei due colori bianco o nero in modo che due nodi vicini abbiano sempre colori diversi. 
 * Quando un grafo è bicolorabile, si dice anche che è bipartito.
 * Osservate che per verificare questa proprietà del grafo è sufficiente eseguire una visita in profondità, assegnando
colori alternati ai vertici che si visitano man mano.
 */
bool twocolor_dfs(Graph g, int v, int *aux, int *colors, bool *next_white) {
	aux[v] = 1;
	for (int j = 0; j < g->n; j++) {
		if (!g->A[v][j] || aux[j])
			continue;

		aux[j] = 1;
		colors[j] = *next_white ? 1 : 2;
		*next_white = (*next_white) ? false : true;

		if (colors[v] == colors[j]) {
			// due nodi dello stesso colore adiacenti => il grafo non è bicolorabile.
			return false;
		}
		if (!twocolor_dfs(g, j, aux, colors, next_white)) {
			// propagazione del risultato; interrompere la visita
			return false;
		}
	}
	return true;
}
bool twocolor(Graph g) {
	int v = 0;
	int *aux = calloc(g->n, sizeof(int));
	int *colors = calloc(g->n, sizeof(int));
	bool next_white = true;
	aux[v] = 0;
	colors[v] = !next_white ? 1 : 2;
	return twocolor_dfs(g, v, aux, colors, &next_white);
}

/*
 * oddcycles testa se il grafo contiene cicli di lunghezza dispari.
 * Si ricorda che un ciclo è un cammino che parte e finisce nello stesso vertice.
 */
bool oddcycles(Graph g) {
	// Se il grafico è bicolorabile, è stato osservato che possono esistere cicli solo di lunghezza pari.
	if (twocolor(g))
		return false;

	// Se mentre visitiamo il grafo otteniamo un elemento già visitato, allora esiste almeno un ciclo.
	// Se esistono cicli allora esistono cicli di lunghezza dispari, altrimenti no.

	// Implemento visita DFS per cercare cicli
	int *visited = calloc(g->n, sizeof(int));
	Queue q;
	init_queue(&q);
	enqueue(&q, 0);
	while (!is_empty(q)) {
		int u = dequeue(&q);

		for (int j = 0; j < g->n; j++) {
			int node = g->A[u][j];
			if (!node)
				continue;

			if (visited[j])  // Trovato ciclo
				return true;

			visited[j] = 1;
			enqueue(&q, j);
		}
	}
	return false;
}

#ifndef DONT_MAIN
int main() {
	/*
	 * CODICE DI TEST ma sopratutto DI DEBUG,
	 * UTILIZZARE UN PROPRIO CLIENT.
	 */

	Graph g;
	g = graph_new(10);
	printf("graph @%lx\n", (long unsigned int) g);
	graph_edgeinsert(g, 3, 5);
	graph_edgeinsert(g, 5, 2);
	graph_print(g);
	// g = graph_read();
	// graph_print(g);
	graph_destroy(g);
	printf("\n------------\n\n");

	g = graph_new(5);
	gen(g, 0.2);
	graph_print(g);

	printf("\n-----(graph_dfs)-----\n\n");
	graph_dfs(g, 0);

	printf("\n-----(graph_bfs)-----\n\n");
	graph_bfs(g, 0);

	printf("degree(0)=%d\n", degree(g, 1));

	printf("path(2, 3)=%d\n", path(g, 1, 2));
	printf("ccc=%d\n", ccc(g));
	cc(g, 1);
	Graph spanning_tree = span(g, 1);
	graph_print(spanning_tree);
	printf("\n----------\n\n");
	graph_print(g);
	printf("shortestpath(1, 3)=%d\n", shortestpath(g, 1, 3));
	printf("twocolor(g)=%d\n", twocolor(g));
	printf("oddcycles(g)=%d\n", oddcycles(g));
	return 0;
}
#endif
