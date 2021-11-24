#include <stdio.h>
#define N 7

typedef int Item;

void stampa(Item a[], int lung) {
	for (Item i = 0; i < lung; i++)
		printf("%d ", a[i]);
	printf("\n");
}

void scambia(Item a[], int i, int j) {
	Item tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}

void selectionsort(Item a[], int n) {
	if (n < 2)
		return;

	int max_idx = 0;
	for (int i = 0; i < n; i++)
		if (a[i] > a[max_idx])
			max_idx = i;

	scambia(a, max_idx, n-1);
	selectionsort(a, n-1);
}

void mergesort(Item a[], int sx, int dx) {
	if (dx - sx <= 1)
		return;

	// Divide
	int mid = (sx + dx) / 2;
	mergesort(a, sx, mid);
	mergesort(a, mid, dx);

	// Impera (merge)
	int i1 = sx;
	int i2 = mid;
	int aux[dx-sx];
	int ix = 0;
	while (i1 < mid && i2 < dx) {
		if (a[i1] > a[i2]) {
			aux[ix++] = a[i2++];
		} else {
			aux[ix++] = a[i1++];
		}
	}

	while (i2 >= dx && i1 < mid)
		aux[ix++] = a[i1++];

	while (i1 >= mid && i2 < dx)
		aux[ix++] = a[i2++];

	for (int i = sx, ix=0; i < dx; i++)
		a[i] = aux[ix++];
}


int main() {
	Item a[N];
	Item n = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", &n);
		a[i] = n;
	}

	mergesort(a, 0, N);
	stampa(a, N);
	return 0;
}
