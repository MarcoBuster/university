#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

#define DIM 10

void print_matrix(char mat[DIM][DIM]) {
	for (int i=0; i < DIM; i++) {
		for (int j=0; j < DIM; j++)
			mat[i][j] == 0 ? printf(". ") : printf("%c ", mat[i][j]);
		printf("\n");
	}
	printf("\n\n");
}

int main(void) {
	char mat[DIM][DIM] = {{}};
	char letter = 'A';
	int x = 0, y = 0;
	int nx = 0, ny = 0;
	int direction;

	srand(time(NULL));

	mat[x][y] = letter++;

	do {
		if ( // the player is stuck
			(x+1 >= DIM || mat[x+1][y] != 0) &&
			(y+1 >= DIM || mat[x][y+1] != 0) &&
			(x-1 < 0 || mat[x-1][y] != 0) &&
			(y-1 < 0 || mat[x][y-1] != 0)
		)
			break;

		direction = rand() % 4;
		nx = x;
		ny = y;
		switch (direction) {
			case 0:
				if (x+1 < DIM) {
					nx++;
					break;
				}
			case 1:
				if (y+1 < DIM) {
					ny++;
					break;
				}
			case 2:
				if (x-1 >= 0) {
					nx--;
					break;
				}
			case 3:
				if (y-1 >= 0) {
					ny--;
					break;
				}
			default:
				continue;
		}
		if (mat[nx][ny] != 0)
			continue;

		x = nx;
		y = ny;
		mat[x][y] = letter;
		print_matrix(mat);
		letter++;
	} while (letter <= 'Z');
	return 0;
}
