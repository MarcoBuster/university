#include <stdio.h>
#include <stdlib.h>

#define SIZE 5

typedef int Item;

typedef struct {
	int items[SIZE+1];
	int front;
	int rear;
} Queue;

void init_queue(Queue *q) {
	q->front = 1;
	q->rear = 0;
}

void enqueue(Queue *q, Item i) {
	if ((++q->rear == SIZE+1))
		q->rear = 1;
	q->items[q->rear] = i;
}

int dequeue(Queue *q) {
	if (q->front == SIZE+1)
		q->front = 1;
	Item x = q->items[q->front++];
	return x;
}

short int is_empty_queue(Queue q) {
	return q.front - q.rear == 1;
}

void print_queue(Queue q) {
	if (is_empty_queue(q)) {
		printf("Queue is empty.\n");
		return;
	}

	for (int i = q.front; i-1 != q.rear; i++) {
		if (i == SIZE+1)
			i = 1;
		printf("%d ", q.items[i]);
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
