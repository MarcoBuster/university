#include <stdbool.h>

typedef struct graph *Graph;

Graph graph_new(int n); 

void graph_destroy(Graph g);

void graph_edgeinsert(Graph g, int v, int w);

Graph graph_read(void);

void graph_print(Graph);

void graph_dfs(Graph, int);

void graph_bfs(Graph, int);

void gen(Graph, float);

int degree(Graph, int);

bool path(Graph, int, int);

int ccc(Graph);

void cc(Graph, int);

Graph span(Graph, int);

int shortestpath(Graph, int, int);

bool twocolor(Graph);

bool oddcycles(Graph);
