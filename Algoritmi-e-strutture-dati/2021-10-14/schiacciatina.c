#include <stdio.h>

#define FREE '*'

int main(void) {
	int r, c;

	printf("# rows? ");
	scanf("%d", &r);

	printf("# columns? ");
	scanf("%d", &c);

	char mat[r][c];

	int i, k;
	for (i=0; i < r; i++)
		scanf("%s", mat[i]);

	for (k=0; k < c; k++) {
		for (i=r-1; i >= 0; i--) {
			if (mat[i][k] != FREE && mat[i+1][k] == FREE) {
				mat[i+1][k] = mat[i][k];
				mat[i][k] = FREE;
				// restart the cycle. ensures that all elements are sorted
				i=r-1;  // complexity?
			}
		}
	}

	// print the matrix
	for (i=0; i < r; i++) {
		for (k=0; k < c; k++)
			printf("%c ", mat[i][k]);
		printf("\n");
	}
	return 0;
}
