#include "list.c"
#include <stdio.h>
#include <stdlib.h>

typedef int Item;

typedef struct {
	Node front;
	Node rear;
} Queue;

void init_queue(Queue *q) {
	q->front = NULL;
	q->rear = NULL;
}

void enqueue(Queue *q, Item i) {
	Node new = malloc(sizeof(Node));
	new->info = i;
	new->next = NULL;

	if (q->rear == NULL) {
		q->rear = new;
		q->front = q->rear;
	} else {
		q->rear->next = new;
		q->rear = new;
	}

}

Item dequeue(Queue *q) {
	Node front = q->front;
	Item x = front->info;

	if (front->next == NULL) {
		q->rear = front->next;
	}
	q->front = front->next;
	free(front);
	return x;
}

short int is_empty(Queue q) {
	return q.front == NULL;
}

void print_queue(Queue q) {
	if (is_empty(q)) {
		printf("Queue is empty.\n");
		return;
	}
	for (Node curr = q.front; curr != NULL; curr = curr->next) {
		printf("%d ", curr->info);
	}
	printf("\n");
}
