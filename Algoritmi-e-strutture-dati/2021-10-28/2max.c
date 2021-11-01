#include <stdio.h>
#include <limits.h>

void max_secondmax(int a[], int n, int *max, int *second_max) {
	*max = INT_MIN;
	for (int i = 0; i < n; i++)
		if (a[i] > *max)
			*max = a[i];

	*second_max = INT_MIN;
	for (int i = 0; i < n; i++)
		if (a[i] < *max && a[i] > *second_max )
			*second_max = a[i];
}

int main() {
	int i, n;
	printf("n? ");
	scanf("%d", &n);

	int input[n];
	for (i = 0; i < n; i++)
		scanf("%d", &input[i]);

	int max, second_max;
	max_secondmax(input, n, &max, &second_max);
	printf("max=%d; second_max=%d", max, second_max);
	return 0;
}
