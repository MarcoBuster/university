#include <stdio.h>
#include <stdlib.h>

typedef int Item;

struct node {
	Item info;
	struct node *next;
};
typedef struct node * Node;

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

int main() {
	Queue q;
	init_queue(&q);
	// Queue should be empty here
	print_queue(q);

	enqueue(&q, 20);
	enqueue(&q, 30);
	enqueue(&q, 40);
	enqueue(&q, 50);
	enqueue(&q, 60);
	print_queue(q);
	printf("Deq: %d\n", dequeue(&q));
	print_queue(q);
	printf("Deq: %d\n", dequeue(&q));
	printf("Deq: %d\n", dequeue(&q));
	printf("Deq: %d\n", dequeue(&q));
	printf("Deq: %d\n", dequeue(&q));

	// Queue should be empty here
	print_queue(q);

	enqueue(&q, 70);
	print_queue(q);
	enqueue(&q, 80);
	enqueue(&q, 90);
	enqueue(&q, 100);
	print_queue(q);
	printf("Deq: %d\n", dequeue(&q));
	printf("Deq: %d\n", dequeue(&q));
	printf("Deq: %d\n", dequeue(&q));
	print_queue(q);
	printf("Deq: %d\n", dequeue(&q));

	// Queue should be empty here
	print_queue(q);
	return 0;
}

