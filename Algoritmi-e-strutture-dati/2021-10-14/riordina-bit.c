#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void swap(int arr[], int j, int k) {
	int tmp;
	tmp = arr[j];
	arr[j] = arr[k];
	arr[k] = tmp;
}

void print_array(int arr[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

int main(void) {
	int n;
	scanf("%d", &n);

	int i;
	int arr[n];
	for (i=0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	// find leftmost 0
	int l;
	for (i=0; i < n; i++)
		if (arr[i] != 0) {
			l = i;
			break;
		}

	// find rightmost 1
	int r;
	for (i=n-1; i >= 0; i--)
		if (arr[i] != 1) {
			r = i;
			break;
		}

	int k;
	for (i=l; i < r; i++) {
		if (arr[i] == 0) {
			swap(arr, i, l);
			l++;
		} else {
			swap(arr, i, r);
			for (k=r; k > l; k--)
				if (arr[k] != 1)
					break;
			r = k;
		}
	}
	print_array(arr, n);
	return 0;
}
