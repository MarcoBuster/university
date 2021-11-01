#include <stdio.h>

#define N 5

int *smallest(int a[], int n) {
	int *min = &a[0];
	for (int i = 1; i < n; i++) {
		if (a[i] < *min)
			min = &a[i];
	}
	return min;
}

int main() {
	int input[N];
	for (int i = 0; i < N; i++) {
		scanf("%d", &input[i]);
	}
	printf("%d", *smallest(input, N));
	return 0;
}
